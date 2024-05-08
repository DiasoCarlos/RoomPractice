package com.example.roomprueba.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.roomprueba.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    campo: String,
    isPassword: Boolean = false,
    isPasswordIconEnabled: Boolean = true,
    isMoney: Boolean = false,
    isNumber: Boolean = false,
    readOnly: Boolean = false,
    placeholderExample: String
) {

    val onlyNumbersPattern = remember { Regex("^\\d+\$") }

    var hidePassword by remember {
        mutableStateOf(true)
    }

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {
            Text(campo)
        },
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFA6C9D6),
            unfocusedBorderColor = Color(0xFFA6C9D6)
        ),
        trailingIcon = {
            if (isPassword) {
                IconButton(
                    onClick = { hidePassword = !hidePassword },
                    enabled = isPasswordIconEnabled
                ) {
                    Icon(
                        painter = if (hidePassword) painterResource(id = R.drawable.ic_visivility_on) else painterResource(
                            id = R.drawable.ic_visibility_off
                        ),
                        contentDescription = "visivility"
                    )
                }
            }
        },
        visualTransformation = if (isPassword && hidePassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (isNumber) {
            KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            )
        } else {
            if (isMoney) {
                KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            } else {
                KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            }
        },
        readOnly = readOnly,
        placeholder = {
            Text(
                text = "P. ej: $placeholderExample",
                color = Color.Gray
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodePickerTextField(
    value: String,
    onValueChange : (String) -> Unit,
    campo: String,
    readOnly : Boolean = false,
    placeholderExample: String,
    leadingIcon : @Composable() () -> Unit
){

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {
            Text(campo)
        },
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFA6C9D6),
            unfocusedBorderColor = Color(0xFFA6C9D6)
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        readOnly = readOnly,
        leadingIcon = { leadingIcon() },
        placeholder = {
            Text(
                text = "P. ej: $placeholderExample",
                color = Color.Gray
            )
        }
    )
}