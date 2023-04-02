package com.napptilus.willywonka.feature.detail.ui

import com.napptilus.willywonka.commonsui.compose.controllers.AppControllers
import com.napptilus.willywonka.commonsui.compose.controllers.ViewController
import com.napptilus.willywonka.core.result.mapBoth
import com.napptilus.willywonka.feature.detail.domain.GetWorkerByIdUseCase
import com.napptilus.willywonka.feature.detail.ui.models.WorkerDetailUI
import com.napptilus.willywonka.feature.detail.ui.models.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val app: AppControllers,
    private val workerId: Int,
    private val getWorkerByIdUseCase: GetWorkerByIdUseCase
) : ViewController(app.coroutinesParams) {

    private val _workerDetail = MutableStateFlow(WorkerDetailUI())
    val workerDetail = _workerDetail.asStateFlow()

    private var _isError = MutableStateFlow(false)
    val isError = _isError.asStateFlow()

    init {
        fetchWorker()
    }

    private fun fetchWorker() {
        scope.launch {
            getWorkerByIdUseCase(workerId).mapBoth(
                success = {
                    _workerDetail.emit(it.toUI())
                },
                failure = {
                    _isError.value = true
                }
            )
        }
    }

    fun onBackButtonClicked() {
        app.navigator.navUp()
    }

    fun onRetryButtonClicked() {
        _isError.value = false
        fetchWorker()
    }
}
