//package com.example.myapplication
//
//import androidx.lifecycle.ViewModel
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlin.random.Random
//
//data class SensorSample(val ts: Long, val type: String, val value: Float)
//
//class DashboardViewModel : ViewModel() {
//    private val _hr = MutableStateFlow(72f)
//    val hr: StateFlow<Float> = _hr.asStateFlow()
//
//    private val _steps = MutableStateFlow(0f)
//    val steps: StateFlow<Float> = _steps.asStateFlow()
//
//    private val _recent = MutableStateFlow<List<SensorSample>>(emptyList())
//    val recentSamples = _recent.asStateFlow()
//
//    private var simJob: Job? = null
//    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
//
//    fun startSimulation() {
//        if (simJob?.isActive == true) return
//        simJob = viewModelScope.launch {
//            while (isActive) {
//                delay(900)
//                val hrVal = 60 + Random.nextInt(0, 90)
//                val stepAdd = Random.nextInt(0, 6)
//                _hr.value = hrVal.toFloat()
//                _steps.value = (_steps.value + stepAdd).toFloat()
//
//                val now = System.currentTimeMillis()
//                val newList = listOf(
//                    SensorSample(now, "HR", _hr.value),
//                    SensorSample(now, "STEPS", _steps.value)
//                ) + _recent.value
//                _recent.value = newList.take(50)
//            }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelScope.cancel()
//    }
//}

package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.*
import kotlin.random.Random

class DashboardViewModel : ViewModel() {

    // Heart rate and steps flows
    private val _hr = MutableStateFlow(72f)
    val hr: StateFlow<Float> = _hr

    private val _steps = MutableStateFlow(0f)
    val steps: StateFlow<Float> = _steps

    private var job: Job? = null

    // Start simulation of data
    fun startSimulation() {
        job = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                // Random heart rate between 65-90
                _hr.value = Random.nextInt(65, 90).toFloat()

                // Random steps increment
                _steps.value += Random.nextInt(0, 5)

                delay(1000) // update every second
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
