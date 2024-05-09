package com.example.roomprueba.ui.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomprueba.domain.model.User
import com.example.roomprueba.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var state by mutableStateOf(SignupState())
        private set

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun onEvent(event: OnSignupEvent) {

        when (event) {
            is OnSignupEvent.OnFirstLastNameChange -> {
                state = state.copy(
                    firstLastName = event.firstLastName
                )
            }

            is OnSignupEvent.OnNameChange -> {
                state = state.copy(
                    name = event.name
                )
            }

            is OnSignupEvent.OnPasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }

            is OnSignupEvent.OnPhoneNumberChange -> {
                state = state.copy(
                    phoneNumber = event.phoneNumber
                )
            }

            is OnSignupEvent.OnSecondLastNameChange -> {
                state = state.copy(
                    secondLastName = event.secondLastName
                )
            }

            is OnSignupEvent.OnUsernameChange -> {
                state = state.copy(
                    username = event.username
                )
            }
        }

    }

}