package com.example.roomprueba.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OTPTextField() {

    var otpCode by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpCode,
        onValueChange = { newValue ->

            if (newValue.length <= 4) {
                otpCode = newValue
            }

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        )
    ) {


        Column() {

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                repeat(4) { index ->

                    val number = when {
                        index >= otpCode.length -> ""
                        else -> otpCode[index].toString()
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {

                        Text(
                            text = number,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Box(modifier = Modifier.width(40.dp).height(2.dp).background(Color.Black))

                    }

                }

            }

        }


    }
}