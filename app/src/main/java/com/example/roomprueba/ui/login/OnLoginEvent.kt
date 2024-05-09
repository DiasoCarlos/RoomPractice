package com.example.roomprueba.ui.login

sealed interface OnLoginEvent {

    data class OnUsernameChange(val username : String) : OnLoginEvent
    data class OnPasswordChange(val password : String) : OnLoginEvent

}