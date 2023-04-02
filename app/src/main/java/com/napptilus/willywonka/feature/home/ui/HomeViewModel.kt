package com.napptilus.willywonka.feature.home.ui

import com.napptilus.willywonka.commonsui.compose.controllers.AppControllers
import com.napptilus.willywonka.commonsui.compose.controllers.ViewController
import com.napptilus.willywonka.commonsui.navigation.transition.NavTransition
import com.napptilus.willywonka.core.result.mapBoth
import com.napptilus.willywonka.feature.detail.ui.DetailScreenDestination
import com.napptilus.willywonka.feature.home.domain.GetAllWorkersUseCase
import com.napptilus.willywonka.feature.home.ui.models.WorkerUI
import com.napptilus.willywonka.feature.home.ui.models.toUI
import com.napptilus.willywonka.utils.FilterType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

private const val ALL_FILTER_VALUE = "All"

class HomeViewModel(
    private val app: AppControllers,
    private val getAllWorkersUseCase: GetAllWorkersUseCase
    ) : ViewController(app.coroutinesParams) {

    private val _workersToShow = MutableStateFlow(mutableListOf<WorkerUI>())
    val workersToShow = _workersToShow.asStateFlow()

    private val allFetchedWorkers = mutableListOf<WorkerUI>()

    private var totalPages = 0
    private var nextPage = 1

    var professions = mutableListOf<String>()
    var genders = mutableListOf<String>()

    private var selectedProfession = ALL_FILTER_VALUE
    private var selectedGender = ALL_FILTER_VALUE

    private var _isError = MutableStateFlow(false)
    val isError = _isError.asStateFlow()

    init {
        fetchWorkers()
    }

    private fun fetchWorkers() {
        scope.launch {
            getAllWorkersUseCase(nextPage).mapBoth(
                success = { response ->
                    val fetchedWorkers = response.results.map { it.toUI() }.toMutableList()
                    _workersToShow.update {
                        updateWorkersToShow(newPage = fetchedWorkers)
                    }
                    totalPages = response.total
                    nextPage += 1
                    updateAllFetchedWorkers(fetchedWorkers)
                    updateFilterListsElements()
                },
                failure = {
                    _isError.value = true
                }
            )
        }
    }

    private fun updateWorkersToShow(newPage: MutableList<WorkerUI>) : MutableList<WorkerUI> {
        return applyFiltersToWorkersToShow(
          currentList =  (allFetchedWorkers + newPage).sortedBy { it.id }.toMutableList()
        )
    }

    private fun applyFiltersToWorkersToShow(currentList: MutableList<WorkerUI>): MutableList<WorkerUI> {
        return if (allFiltersAreSelected()) {
            applyAllFiltersTo(currentList)
        } else if (someFiltersAreSelected()) {
            applySomeFiltersTo(currentList)
        } else {
            currentList
        }
    }

    private fun allFiltersAreSelected() : Boolean {
        return selectedProfession != ALL_FILTER_VALUE && selectedGender != ALL_FILTER_VALUE
    }

    private fun applyAllFiltersTo(list: MutableList<WorkerUI>): MutableList<WorkerUI> =
        list.filter {
            it.profession == selectedProfession && it.gender == selectedGender
        }.toMutableList()

    private fun someFiltersAreSelected() : Boolean {
        return selectedProfession != ALL_FILTER_VALUE || selectedGender != ALL_FILTER_VALUE
    }

    private fun applySomeFiltersTo(list: MutableList<WorkerUI>): MutableList<WorkerUI> =
        list.filter {
            it.profession == selectedProfession || it.gender == selectedGender
        }.toMutableList()

    private fun updateAllFetchedWorkers(newFetchedWorkers: MutableList<WorkerUI>) {
        allFetchedWorkers.addAll(newFetchedWorkers)
    }

    private fun updateFilterListsElements() {
        updateFilterProfessionsListElements()
        updateFilterGendersListElements()
    }

    private fun updateFilterProfessionsListElements() {
        professions = allFetchedWorkers.map {
            it.profession
        }.toSet().toMutableList()
        professions.add(ALL_FILTER_VALUE)
    }

    private fun updateFilterGendersListElements() {
        genders = allFetchedWorkers.map {
            it.gender
        }.toSet().toMutableList()
        genders.add(ALL_FILTER_VALUE)
    }

    private fun areWorkersToFetch() : Boolean =_workersToShow.value.isNotEmpty() && nextPage < totalPages

    fun onEndScroll() {
        if (areWorkersToFetch()) {
            fetchWorkers()
        }
    }

    fun onItemClicked(workerId: Int?) {
        if (workerId != null) {
            app.navigator.goTo(DetailScreenDestination(workerId), transition = NavTransition.SharedAxisX)
        } else {
            Timber.tag("ERROR").e("User has a null id")
        }
    }

    fun onFilterItemClicked (
        filterValue: String,
        filterType: FilterType
    )
    {
        when(filterType){
            FilterType.PROFESSION -> selectedProfession = filterValue
            FilterType.GENDER -> selectedGender = filterValue
        }
        if (areWorkersToFetch()) {
            fetchWorkers() //Before apply filtering, the next fetch is executed to get more elements
        } else {
            _workersToShow.update {
                applyFiltersToWorkersToShow(
                    currentList = allFetchedWorkers
                ).sortedBy { it.id }.toMutableList()
            }
        }
    }

    fun onRetryButtonClicked() {
        _isError.value = false
        fetchWorkers()
    }
}