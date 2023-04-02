package com.napptilus.willywonka.feature.home.domain

import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.core.result.mapError
import com.napptilus.willywonka.core.usecase.UseCaseSuspend
import com.napptilus.willywonka.network.responsemodels.AllWorkersResponse

interface GetAllWorkersUseCase : UseCaseSuspend<Int, MyResult<AllWorkersResponse, GenericApiError>>

class GetAllWorkersUseCaseImpl(
    private val homeDataSource: HomeDataSource
) : GetAllWorkersUseCase {
    override suspend fun invoke (page: Int): MyResult<AllWorkersResponse, GenericApiError> {
        return homeDataSource.getAllWorkers(page).mapError { it }
    }
}