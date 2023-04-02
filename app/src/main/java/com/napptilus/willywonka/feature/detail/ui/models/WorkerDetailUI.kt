package com.napptilus.willywonka.feature.detail.ui.models

import com.napptilus.willywonka.network.responsemodels.FavoriteResponse
import com.napptilus.willywonka.network.responsemodels.WorkerResponse
import kotlinx.serialization.Serializable

@Serializable
data class WorkerDetailUI(
    val age: Int = 0,
    val country: String = "",
    val email: String = "",
    val favorite: FavoriteUI = FavoriteUI(),
    val first_name: String = "",
    val gender: String = "",
    val height: Int = 0,
    val id: Int? = 0,
    val image: String = "",
    val last_name: String = "",
    val profession: String = "",
    val description: String? = "",
    val quota: String? = ""
)

@Serializable
data class FavoriteUI(
    val color: String = "",
    val food: String = "",
    val song: String = "",
)

internal fun WorkerResponse.toUI() = WorkerDetailUI(
    age = age,
    country = country,
    email = email,
    favorite = favorite.toUI(),
    first_name = first_name,
    gender = gender,
    height = height,
    id = id,
    image = image,
    last_name = last_name,
    profession = profession,
    description = description,
    quota = quota
)

private fun FavoriteResponse.toUI() = FavoriteUI(
    color = color,
    food = food,
    song = song
)



