package com.napptilus.willywonka.feature.home.data

import com.napptilus.willywonka.core.result.ApiErrorHandling
import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.feature.home.domain.HomeDataSource
import com.napptilus.willywonka.network.api.Api
import com.napptilus.willywonka.network.responsemodels.AllWorkersResponse

class HomeDataSourceImpl(
    private val api: Api
) : HomeDataSource {
    override suspend fun getAllWorkers(page: Int): MyResult<AllWorkersResponse, GenericApiError> =
        ApiErrorHandling.run {
            api.getAllWorkers(page)
    }
}