package com.napptilus.willywonka.presentation

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.napptilus.willywonka.commonsui.compose.theme.providers.LocalMotionTransition
import com.napptilus.willywonka.commonsui.navigation.NavPop
import com.napptilus.willywonka.commonsui.navigation.Navigator
import com.napptilus.willywonka.commonsui.navigation.Route
import com.napptilus.willywonka.commonsui.navigation.transition.getEnterTransition
import com.napptilus.willywonka.commonsui.navigation.transition.getExitTransition
import com.napptilus.willywonka.commonsui.navigation.transition.getPopEnterTransition
import com.napptilus.willywonka.commonsui.navigation.transition.getPopExitTransition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationHost(startDestinationPath: String, navGraph: NavGraphBuilder.() -> Unit) {
    val navController = rememberAnimatedNavController()

    NavHost(navController, startDestinationPath, navGraph)

    val navigator: Navigator = get()
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    LaunchedEffect(Unit) {
        handleNavEvents(navigator, navController) { backDispatcher?.onBackPressed() }
    }
}

private fun CoroutineScope.handleNavEvents(
    navigator: Navigator,
    navController: NavHostController,
    onSystemBack: () -> Unit,
) {
    launch {
        navigator.directions.collect { route ->
            when (route) {
                is Route.Forward -> navController.navigate(route.destination) {
                    setupPopStrategy(route.popStrategy, navController.graph.startDestinationId)
                    launchSingleTop = route.launchSingleTop
                }
                Route.Up -> navController.navigateUp()
                Route.Back -> onSystemBack()
            }
        }
    }
}

private fun NavOptionsBuilder.setupPopStrategy(strategy: NavPop, startDestinationId: Int) {
    when (strategy) {
        is NavPop.Exclusive -> popUpTo(strategy.upTo.route) { inclusive = false }
        is NavPop.Inclusive -> popUpTo(strategy.upTo.route) { inclusive = true }
        NavPop.Nothing -> {}
        NavPop.Start -> popUpTo(startDestinationId)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun NavHost(
    navController: NavHostController,
    startDestinationPath: String,
    navGraph: NavGraphBuilder.() -> Unit,
) {
    val motionTransition = LocalMotionTransition.current

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestinationPath,
        enterTransition = {
            getEnterTransition(motionTransition)
        },
        exitTransition = {
            getExitTransition(motionTransition)
        },
        popEnterTransition = {
            getPopEnterTransition(motionTransition)
        },
        popExitTransition = {
            getPopExitTransition(motionTransition)
        },
    ) {
        navGraph()
    }
}
