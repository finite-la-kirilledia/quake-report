package com.example.quakereport

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class LoadingStatus { LOADING, ERROR, DONE }

class QuakeViewModel : ViewModel() {
    val loadingStatus = MutableLiveData<LoadingStatus>()

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val quakes = MutableLiveData<List<Quake>>()

    init {
        viewModelScope.launch {
            try {
                loadingStatus.value = LoadingStatus.LOADING
                quakes.value = QuakeApi.service.getUsgsResponse().await().asDomainModel()
                loadingStatus.value = LoadingStatus.DONE
            } catch (e: Exception) {
                loadingStatus.value = LoadingStatus.ERROR
                quakes.value = emptyList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}