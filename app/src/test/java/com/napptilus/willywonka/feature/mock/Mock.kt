package com.napptilus.willywonka.feature.mock

import com.napptilus.willywonka.network.responsemodels.AllWorkersResponse
import com.napptilus.willywonka.network.responsemodels.FavoriteResponse
import com.napptilus.willywonka.network.responsemodels.WorkerResponse


val mockAllWorkersResponse = AllWorkersResponse(
    current = 1,
    total =20,
    results = emptyList())

val mockFavoriteResponse  = FavoriteResponse(
    color = "fakeColor",
    food = "fakeFood",
    random_string = "fakeRandomString",
    song = "fakeSong"
)

val mockWorkerResponse = WorkerResponse(
    age = 99,
    country = "CountryMock",
    email = "emailMock",
    favorite = mockFavoriteResponse,
    first_name = "first_nameMock",
    gender = "genderMock",
    height = 99,
    id = 1,
    description = "descriptionMock",
    quota = "quotaMock",
    image = "imageMock",
    last_name = "last_nameMock",
    profession = "professionMoxk"
)

