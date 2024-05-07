package com.example.roomprueba.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TestScren(
    nombre : String,
    apellido: String,
    monto:String,
    telefono : String
) {

    Column {
        Text(text = nombre)
        Text(text = apellido)
        Text(text = monto)
        Text(text = telefono)
    }
    
}