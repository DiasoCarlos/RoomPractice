package com.example.roomprueba.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomprueba.ui.theme.RoomPruebaTheme
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomPruebaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    viewModel : MainViewModel = hiltViewModel()
) {
    val beneficiarios by viewModel.beneficiarios.collectAsState(initial = emptyList())

    val state = rememberKomposeCountryCodePickerState(
        showCountryCode = true,
        showCountryFlag = true
    )
    val phoneNumber = rememberSaveable() {
        mutableStateOf("")
    }

    Column {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                viewModel.addBeneficiario()
            }) {
                Text("Add Items")
            }
            Button(onClick = {
                viewModel.deleteAll()
            }) {
                Text("Delete Items")
            }

        }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = phoneNumber.value,
            onValueChange = {
                phoneNumber.value = it
            },
            placeholder = { Text(text = "Telefono")},
            leadingIcon = {
                KomposeCountryCodePicker(
                    state = state,
                    text = phoneNumber.value,
                    showOnlyCountryCodePicker = true
                )
            }
        )

        if (state.phoneNumber.isNotEmpty()){
            Text(text = state.getFullPhoneNumber())
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            items(beneficiarios) { item ->
                Row {
                    Text(item.nombre)
                    Spacer(Modifier.height(3.dp))
                    Text(item.apellido)
                    Spacer(Modifier.height(3.dp))
                    Text(item.numero)
                    Spacer(Modifier.height(3.dp))
                    Text(item.calle)
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    }
}