package com.napptilus.willywonka.network.responsemodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllWorkersResponse(
    @SerialName("current")
    val current: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("results")
    val results: List<WorkerResponse>,
)
