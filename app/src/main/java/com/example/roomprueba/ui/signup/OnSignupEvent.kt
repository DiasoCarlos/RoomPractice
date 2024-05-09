package com.example.roomprueba.ui.signup

sealed interface OnSignupEvent {

    data class OnUsernameChange(val username : String) : OnSignupEvent
    data class OnPasswordChange(val password : String) : OnSignupEvent
    data class OnNameChange(val name : String) : OnSignupEvent
    data class OnFirstLastNameChange(val firstLastName : String) : OnSignupEvent
    data class OnSecondLastNameChange(val secondLastName : String) : OnSignupEvent
    data class OnPhoneNumberChange(val phoneNumber : String) : OnSignupEvent

}