package com.napptilus.willywonka.network.responsemodels

import kotlinx.serialization.Serializable

@Serializable
data class WorkerResponse(
    val age: Int,
    val country: String,
    val email: String,
    val favorite: FavoriteResponse,
    val first_name: String,
    val gender: String,
    val height: Int,
    val id: Int? = null,
    val image: String,
    val last_name: String,
    val profession: String,
    val description: String? = null,
    val quota: String? = null,
)