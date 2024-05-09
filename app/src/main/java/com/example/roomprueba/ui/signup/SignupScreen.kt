package com.example.roomprueba.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomprueba.domain.model.User
import com.example.roomprueba.ui.components.CustomTextField
import com.example.roomprueba.ui.login.OnLoginEvent

@Composable
fun SignupScreen(
    viewModel: SignupViewModel = hiltViewModel(),
    onRegisterClick : () -> Unit
) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomTextField(
            value = state.username,
            onValueChange = {
                viewModel.onEvent(
                    OnSignupEvent.OnUsernameChange(it)
                )
            },
            campo = "Username",
            placeholderExample = "pepe22"
        )

        CustomTextField(
            value = state.password,
            onValueChange = {
                viewModel.onEvent(
                    OnSignupEvent.OnPasswordChange(it)
                )
            },
            campo = "Password",
            placeholderExample = "*****"
        )
        CustomTextField(
            value = state.name,
            onValueChange = {
                viewModel.onEvent(
                    OnSignupEvent.OnNameChange(it)
                )
            },
            campo = "nombre",
            placeholderExample = "carlos"
        )
        CustomTextField(
            value = state.firstLastName,
            onValueChange = {
                viewModel.onEvent(
                    OnSignupEvent.OnFirstLastNameChange(it)
                )
            },
            campo = "Appellido Paterno",
            placeholderExample = "Lopez"
        )
        CustomTextField(
            value = state.secondLastName,
            onValueChange = {
                viewModel.onEvent(
                    OnSignupEvent.OnSecondLastNameChange(it)
                )
            },
            campo = "Appellido Materno",
            placeholderExample = "Lopez"
        )
        CustomTextField(
            value = state.phoneNumber,
            onValueChange = {
                viewModel.onEvent(
                    OnSignupEvent.OnPhoneNumberChange(it)
                )
            },
            campo = "Numero",
            placeholderExample = "2131332"
        )

        Button(onClick = {
            viewModel.addUser(
                User(
                    nameUser = state.name,
                    username = state.username,
                    firstLastName = state.firstLastName,
                    secondLastName = state.secondLastName,
                    password = state.password,
                    phoneNumber = state.phoneNumber
                )
            )
            onRegisterClick()
        }) {
            Text(text = "Registro")
        }

    }

}