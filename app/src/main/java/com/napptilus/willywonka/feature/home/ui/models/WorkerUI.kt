package com.napptilus.willywonka.feature.home.ui.models

import com.napptilus.willywonka.network.responsemodels.WorkerResponse
import kotlinx.serialization.Serializable

@Serializable
data class WorkerUI(
    val country: String,
    val email: String,
    val first_name: String,
    val gender: String,
    val id: Int?,
    val image: String,
    val profession: String,
)

internal fun WorkerResponse.toUI() = WorkerUI(
    country = country,
    email = email,
    first_name = first_name,
    gender = gender,
    id = id,
    image = image,
    profession = profession
)