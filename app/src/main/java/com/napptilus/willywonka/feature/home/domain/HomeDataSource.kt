package com.napptilus.willywonka.feature.home.domain

import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.network.responsemodels.AllWorkersResponse

interface HomeDataSource {
    suspend fun getAllWorkers(page: Int): MyResult<AllWorkersResponse, GenericApiError>
}