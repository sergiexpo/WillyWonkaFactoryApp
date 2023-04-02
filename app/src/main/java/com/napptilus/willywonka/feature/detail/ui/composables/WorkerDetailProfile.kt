package com.napptilus.willywonka.feature.detail.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.napptilus.willywonka.R
import com.napptilus.willywonka.feature.detail.ui.models.WorkerDetailUI
import com.napptilus.willywonka.utils.getGenderText

@Composable
fun WorkerDetailProfile(worker: WorkerDetailUI) {

    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.gender),
        text = stringResource(id = worker.gender.getGenderText())
    )
    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.age),
        text = worker.age.toString()
    )
    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.height),
        text = worker.height.toString()
    )
    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.profession),
        text = worker.profession
    )
    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.email),
        text = worker.email
    )
    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.country),
        text = worker.country
    )
    WorkerDetailProfileLongComponent(
        title = stringResource(id = R.string.song),
        text = worker.favorite.song
    )
    WorkerDetailProfileComponent(
        label = stringResource(id = R.string.favorites),
        text = worker.favorite.food + " / " + worker.favorite.color
    )
    WorkerDetailProfileLongComponent(
        title = stringResource(id = R.string.quota),
        text = worker.quota.toString()
    )
    WorkerDetailProfileLongComponent(
        title = stringResource(id = R.string.description),
        text = worker.description.toString()
    )

}