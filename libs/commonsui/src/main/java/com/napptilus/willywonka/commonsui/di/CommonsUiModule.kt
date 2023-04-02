package com.napptilus.willywonka.commonsui.di

import com.napptilus.willywonka.commonsui.compose.controllers.AppControllers
import com.napptilus.willywonka.commonsui.navigation.Navigator
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val commonsUiModule = module {
    single { Navigator() }
    factoryOf(::AppControllers)
}
