package com.example.roomprueba.ui.login

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
import com.example.roomprueba.ui.components.CustomTextField

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onSignUpClick: () -> Unit,
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
                    OnLoginEvent.OnUsernameChange(it)
                )
            },
            campo = "Username",
            placeholderExample = "pepe22"
        )

        CustomTextField(
            value = state.password,
            onValueChange = {
                viewModel.onEvent(
                    OnLoginEvent.OnPasswordChange(it)
                )
            },
            campo = "Password",
            placeholderExample = "*****"
        )
        
        Button(onClick = { /*TODO*/ }) {
            
        }
        
        Button(onClick = {
            onRegisterClick()
        }) {
            Text(text = "Registro")
        }

    }

}