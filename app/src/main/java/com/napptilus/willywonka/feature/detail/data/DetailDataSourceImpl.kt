package com.napptilus.willywonka.feature.detail.data

import com.napptilus.willywonka.core.result.ApiErrorHandling
import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.feature.detail.domain.DetailDataSource
import com.napptilus.willywonka.network.api.Api
import com.napptilus.willywonka.network.responsemodels.WorkerResponse

class DetailDataSourceImpl(
    private val api: Api
) : DetailDataSource {
    override suspend fun getWorkerById(id: Int): MyResult<WorkerResponse, GenericApiError> =
        ApiErrorHandling.run {
            api.getWorkerById(id)
        }
}