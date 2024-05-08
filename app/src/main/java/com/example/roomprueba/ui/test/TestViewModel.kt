package com.example.roomprueba.ui.test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomprueba.ui.home.HomeEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(TestState())
        private set

    fun onEvent(event: TestEvents) {

        when (event) {
            is TestEvents.ApellidoChange -> {
                state = state.copy(
                    apellido = event.apellido
                )
            }

            is TestEvents.MontoChange -> {
                state = state.copy(
                    monto = event.monto
                )
            }

            is TestEvents.NameChange -> {
                state = state.copy(
                    nombre = event.nombre
                )
            }

            is TestEvents.NumberChange -> {
                if (event.number.length <= 10) {
                    state = state.copy(
                        telefono = event.number
                    )
                }
            }

            TestEvents.ClearFields -> {
                state = state.copy(
                    nombre = "",
                    apellido = "",
                    monto = "",
                    telefono = ""
                )
            }
        }

    }

}