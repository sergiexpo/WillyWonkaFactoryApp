package com.napptilus.willywonka.feature.home.ui.composables

import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.napptilus.willywonka.feature.home.ui.models.WorkerUI

@Suppress("FrequentlyChangedStateReadInComposition")
@Composable
fun WorkerList(
    modifier: Modifier = Modifier,
    workers: List<WorkerUI>,
    onItemClicked: (Int?) -> Unit,
    scrolledDown: () -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = listState,
    ) {
        items(
            items = workers
        ) {
            WorkerItem(
                item = it,
                onItemClicked = onItemClicked
            )
        }
    }
    listState.OnBottomReached {
        scrolledDown()
    }
}

@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true
            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }.collect {
                if (it) loadMore()
            }
    }
}