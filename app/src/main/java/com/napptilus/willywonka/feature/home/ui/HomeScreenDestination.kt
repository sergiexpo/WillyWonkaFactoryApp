package com.napptilus.willywonka.feature.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.napptilus.willywonka.R
import com.napptilus.willywonka.commonsui.compose.savestate.buildSaver
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme
import com.napptilus.willywonka.commonsui.navigation.Destination
import com.napptilus.willywonka.commonsui.navigation.DestinationDeclaration
import com.napptilus.willywonka.commonsui.navigation.getWith
import com.napptilus.willywonka.commonsui.utils.collectWithLifecycle
import com.napptilus.willywonka.composables.GenericError
import com.napptilus.willywonka.feature.home.ui.composables.HomeFilterComponent
import com.napptilus.willywonka.feature.home.ui.composables.WorkerList
import com.napptilus.willywonka.feature.home.ui.models.WorkerUI
import com.napptilus.willywonka.utils.FilterType
import org.koin.core.scope.Scope


class HomeScreenDestination : Destination<Unit>() {
    @Composable
    override fun Content(navEntry: NavBackStackEntry, diScope: Scope, outerArgs: Unit) {
        HomeScreen(diScope.getWith(navEntry.savedStateHandle.buildSaver()))
    }

    companion object : DestinationDeclaration<HomeScreenDestination>(
        HomeScreenDestination::class
    )
}

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val workers by homeViewModel.workersToShow.collectWithLifecycle()
    val isError by homeViewModel.isError.collectWithLifecycle()
    val professions = homeViewModel.professions
    val genders = homeViewModel.genders


    if (isError) {

        GenericError(
            title = stringResource(id = R.string.error),
            description = stringResource(id = R.string.generic_error),
            onRetryButtonClicked = homeViewModel::onRetryButtonClicked
        )

    } else {
        HomeScreenContent(
            workers = workers,
            professions = professions,
            genders = genders,
            onFilterItemClicked = homeViewModel::onFilterItemClicked,
            onEndScroll = homeViewModel::onEndScroll,
            onItemClicked = homeViewModel::onItemClicked
        )

    }
}

@Composable
fun HomeScreenContent(
    workers: MutableList<WorkerUI>,
    professions: MutableList<String>,
    genders: MutableList<String>,
    onFilterItemClicked: (String, FilterType) -> Unit,
    onEndScroll: () -> Unit,
    onItemClicked: (Int?) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column() {
            Text(
                modifier = Modifier
                    .padding(all = 16.dp),
                text = stringResource(id = R.string.home_title),
                style = AppTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                HomeFilterComponent(
                    title = stringResource(id = R.string.profession),
                    listItems = professions,
                    filterType = FilterType.PROFESSION,
                    onFilterItemClicked = onFilterItemClicked
                )
                HomeFilterComponent(
                    title = stringResource(id = R.string.gender),
                    listItems = genders,
                    filterType = FilterType.GENDER,
                    onFilterItemClicked = onFilterItemClicked
                )
            }
            WorkerList(
                workers = workers,
                scrolledDown = onEndScroll,
                onItemClicked = onItemClicked
            )
        }
    }
}