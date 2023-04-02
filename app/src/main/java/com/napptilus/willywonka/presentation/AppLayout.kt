package com.napptilus.willywonka.presentation

import androidx.compose.runtime.Composable

@Composable
fun AppLayout() {
    NavigationHost(startDestinationPath = RootNavGraph.StartDestination.route) {
        rootNavGraph()
    }
}
