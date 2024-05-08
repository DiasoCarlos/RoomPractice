package com.example.roomprueba.ui.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomprueba.ui.components.CodePickerTextField
import com.example.roomprueba.ui.components.CustomTextField
import com.example.roomprueba.ui.home.HomeEvents
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState

@Composable
fun TestScren(
    viewModel: TestViewModel = hiltViewModel(),
    nombre: String,
    apellido: String,
    monto: String,
    telefono: String
) {

    val state = viewModel.state

    val codePickerState = rememberKomposeCountryCodePickerState(
        showCountryCode = true,
        showCountryFlag = true,
        limitedCountries = listOf("MX", "US"),
        defaultCountryCode = "MX"
    )

    Column {
        Text(text = nombre)
        Text(text = apellido)
        Text(text = monto)
        Text(text = telefono)


        CustomTextField(
            value = state.nombre,
            onValueChange = { nombre ->
                viewModel.onEvent(
                    TestEvents.NameChange(nombre)
                )
            },
            campo = "Nombre",
            placeholderExample = "Juan"
        )
        CustomTextField(
            value = state.apellido,
            onValueChange = { apellido ->
                viewModel.onEvent(
                    TestEvents.ApellidoChange(apellido)
                )
            },
            campo = "Apellido",
            placeholderExample = "Perez"
        )
        CustomTextField(
            value = state.monto,
            onValueChange = { monto ->
                viewModel.onEvent(
                    TestEvents.MontoChange(monto)
                )
            },
            campo = "Monto",
            isMoney = true,
            placeholderExample = "200,000.00"
        )
        CodePickerTextField(
            value = state.telefono,
            onValueChange = { telefono ->
                viewModel.onEvent(
                    TestEvents.NumberChange(telefono)
                )
            },
            campo = "Telefono",
            placeholderExample = "5529837462"
        ) {
            KomposeCountryCodePicker(
                state = codePickerState,
                text = state.telefono,
                showOnlyCountryCodePicker = true
            )
        }

        Button(
            onClick = {
                viewModel.onEvent(
                    TestEvents.ClearFields
                )
            }
        ) {
            Text(text = "Limpiar campos")
        }
    }

}