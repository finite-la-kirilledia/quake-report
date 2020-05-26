package com.example.quakereport

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class QuakeViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val quakes = MutableLiveData<List<Quake>>()

    init {
        viewModelScope.launch {
            quakes.value = QuakeApi.service.getUsgsResponse().await().asDomainModel()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}