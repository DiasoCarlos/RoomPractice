package com.example.roomprueba.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: OnLoginEvent){

        when(event){
            is OnLoginEvent.OnPasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
            is OnLoginEvent.OnUsernameChange -> {
                state = state.copy(
                    username = event.username
                )
            }
        }

    }

}