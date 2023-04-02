package com.napptilus.willywonka.network.responsemodels

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteResponse(
    val color: String,
    val food: String,
    val random_string: String,
    val song: String,
)