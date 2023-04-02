package com.napptilus.willywonka.feature.home.di

import com.napptilus.willywonka.core.utils.Cancellable
import com.napptilus.willywonka.feature.home.data.HomeDataSourceImpl
import com.napptilus.willywonka.feature.home.domain.GetAllWorkersUseCase
import com.napptilus.willywonka.feature.home.domain.GetAllWorkersUseCaseImpl
import com.napptilus.willywonka.feature.home.domain.HomeDataSource
import com.napptilus.willywonka.feature.home.ui.HomeScreenDestination
import com.napptilus.willywonka.feature.home.ui.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.scopedOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeModule = module {

    scope<HomeScreenDestination> {
        scopedOf(::HomeViewModel) bind Cancellable::class
    }

    factoryOf(::GetAllWorkersUseCaseImpl) bind GetAllWorkersUseCase::class
    factoryOf(::HomeDataSourceImpl) bind HomeDataSource::class
}