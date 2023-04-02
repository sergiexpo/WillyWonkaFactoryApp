package com.napptilus.willywonka.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.napptilus.willywonka.commonsui.navigation.scopedComposable
import com.napptilus.willywonka.feature.detail.ui.DetailScreenDestination
import com.napptilus.willywonka.feature.home.ui.HomeScreenDestination

object RootNavGraph {
  val StartDestination = HomeScreenDestination
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.rootNavGraph() {
    scopedComposable(HomeScreenDestination)
    scopedComposable(DetailScreenDestination)
}
