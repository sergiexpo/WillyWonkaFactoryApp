package com.napptilus.willywonka.feature.detail.domain

import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.network.responsemodels.WorkerResponse

interface DetailDataSource {
    suspend fun getWorkerById(id: Int): MyResult<WorkerResponse, GenericApiError>
}