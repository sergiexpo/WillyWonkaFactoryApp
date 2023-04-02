package com.napptilus.willywonka.feature.detail.di

import com.napptilus.willywonka.core.utils.Cancellable
import com.napptilus.willywonka.feature.detail.data.DetailDataSourceImpl
import com.napptilus.willywonka.feature.detail.domain.DetailDataSource
import com.napptilus.willywonka.feature.detail.domain.GetWorkerByIdUseCase
import com.napptilus.willywonka.feature.detail.domain.GetWorkerByIdUseCaseImpl
import com.napptilus.willywonka.feature.detail.ui.DetailScreenDestination
import com.napptilus.willywonka.feature.detail.ui.DetailViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.scopedOf
import org.koin.dsl.bind
import org.koin.dsl.module

val detailModule = module {

    scope<DetailScreenDestination> {
        scopedOf(::DetailViewModel) bind Cancellable::class
    }

    factoryOf(::GetWorkerByIdUseCaseImpl) bind GetWorkerByIdUseCase::class
    factoryOf(::DetailDataSourceImpl) bind DetailDataSource::class
}