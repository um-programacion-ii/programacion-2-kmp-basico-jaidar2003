package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height // Added import
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp // Added import
import androidx.compose.ui.unit.sp // Added import

@Composable
fun App() {
    MaterialTheme {
        var name: String by remember { mutableStateOf("") }
        var name2: String by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            TextField(
                value = name,
                onValueChange = {
                    name = it
                }
            )

            TextField(
                value = name2,
                onValueChange = {
                    name2 = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (name.isNotEmpty()) {
                Text(
                    text = "Ingreso de $name",
                    fontSize = 24.sp // Corrected parameter name
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            AnimatedVisibility(name.isNotEmpty()){
                Text(
                    text = "Version animada de $name", // Added comma
                    fontSize = 24.sp // Corrected parameter name
                )
            }

            AnimatedVisibility(name2.isNotEmpty()){
                Text(
                    text = "Version animada de $name2", // Added comma
                    fontSize = 24.sp // Corrected parameter name
                )
            }
        }
    }
}
