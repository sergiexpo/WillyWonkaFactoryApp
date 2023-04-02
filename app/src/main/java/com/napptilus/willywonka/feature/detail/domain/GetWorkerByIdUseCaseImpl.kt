package com.napptilus.willywonka.feature.detail.domain

import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.core.result.mapError
import com.napptilus.willywonka.core.usecase.UseCaseSuspend
import com.napptilus.willywonka.network.responsemodels.WorkerResponse

interface GetWorkerByIdUseCase : UseCaseSuspend<Int, MyResult<WorkerResponse, GenericApiError>>

class GetWorkerByIdUseCaseImpl(
    private val detailDataSource: DetailDataSource
) : GetWorkerByIdUseCase {
    override suspend fun invoke (id: Int): MyResult<WorkerResponse, GenericApiError> {
        return detailDataSource.getWorkerById(id).mapError { it }
    }
}