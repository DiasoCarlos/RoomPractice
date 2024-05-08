package com.example.roomprueba.ui.home

sealed interface HomeEvents {

    data class NumberChange( val number: String) : HomeEvents

}