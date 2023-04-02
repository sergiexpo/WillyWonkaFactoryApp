package com.napptilus.willywonka.feature.detail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import com.napptilus.willywonka.R
import com.napptilus.willywonka.commonsui.navigation.Destination
import com.napptilus.willywonka.commonsui.navigation.DestinationDeclaration
import com.napptilus.willywonka.commonsui.navigation.getWith
import com.napptilus.willywonka.commonsui.utils.collectWithLifecycle
import com.napptilus.willywonka.composables.GenericError
import com.napptilus.willywonka.composables.TopBarComponent
import com.napptilus.willywonka.feature.detail.ui.composables.WorkerDetailImage
import com.napptilus.willywonka.feature.detail.ui.composables.WorkerDetailProfile
import com.napptilus.willywonka.feature.detail.ui.composables.WorkerDetailTitle
import com.napptilus.willywonka.feature.detail.ui.models.WorkerDetailUI
import org.koin.core.scope.Scope

class DetailScreenDestination(
    val workerId: Int
) : Destination<Unit>() {
    @Composable
    override fun Content(navEntry: NavBackStackEntry, diScope: Scope, outerArgs: Unit) {
        DetailScreen(diScope.getWith(workerId))
    }

    companion object : DestinationDeclaration<DetailScreenDestination>(
        DetailScreenDestination::class
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(detailViewModel: DetailViewModel) {

    val worker by detailViewModel.workerDetail.collectWithLifecycle()
    val isError by detailViewModel.isError.collectWithLifecycle()


    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(topBar = {
            TopBarComponent(onBackButtonClicked = detailViewModel::onBackButtonClicked)
        })
        {
            if (isError) {
                GenericError(
                    title = stringResource(id = R.string.error),
                    description = stringResource(id = R.string.generic_error),
                    onRetryButtonClicked = detailViewModel::onRetryButtonClicked
                )
            } else {
                DetailScreenContent(
                    paddingValues = it,
                    worker = worker
                )
            }
        }
    }
}

@Composable
fun DetailScreenContent(
    paddingValues: PaddingValues,
    worker: WorkerDetailUI
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        WorkerDetailImage(imageUrl = worker.image)
        WorkerDetailTitle(title = worker.first_name + " " + worker.last_name)
        WorkerDetailProfile(worker = worker)
    }
}