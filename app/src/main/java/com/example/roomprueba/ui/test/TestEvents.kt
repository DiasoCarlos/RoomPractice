package com.example.roomprueba.ui.test

sealed interface TestEvents {

    data class NameChange(val nombre : String) : TestEvents
    data class ApellidoChange(val apellido : String) : TestEvents
    data class MontoChange(val monto : String) : TestEvents
    data class NumberChange(val number : String) : TestEvents
    object ClearFields : TestEvents

}