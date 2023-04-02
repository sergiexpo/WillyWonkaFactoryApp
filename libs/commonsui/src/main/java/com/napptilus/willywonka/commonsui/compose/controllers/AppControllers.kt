package com.napptilus.willywonka.commonsui.compose.controllers

import com.napptilus.willywonka.commonsui.navigation.Navigator
import com.napptilus.willywonka.core.app.FrontCoroutinesParams
import kotlinx.coroutines.CoroutineScope

data class AppControllers(
    val appScope: CoroutineScope,
    val coroutinesParams: FrontCoroutinesParams,
    val navigator: Navigator,
)
