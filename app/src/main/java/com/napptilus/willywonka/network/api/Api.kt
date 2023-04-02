package com.napptilus.willywonka.network.api

import com.napptilus.willywonka.network.responsemodels.AllWorkersResponse
import com.napptilus.willywonka.network.responsemodels.WorkerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val URL_EXTENSION = "oompa-loompas/"

interface Api {
    @GET(URL_EXTENSION)
    suspend fun getAllWorkers(
        @Query("page") page: Int,
    ): AllWorkersResponse


    @GET("$URL_EXTENSION{id}")
    suspend fun getWorkerById(
        @Path("id") id:Int
    ): WorkerResponse
}