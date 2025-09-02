package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.basic.project.bottomBar.BottomBarScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen())
    }}

class MainScreen: Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        var name: String by remember { mutableStateOf("") }
        var name2: String by remember { mutableStateOf("") }
        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize()
            ,
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
            Spacer(modifier = Modifier.height(40.dp))

            AnimatedVisibility(visible = name.isNotEmpty()){
                Text(
                    text = "Version 1 $name",
                    fontSize = 24.sp
                )
            }

            AnimatedVisibility(visible = name2.isNotEmpty()){
                Text(
                    text = "Version 2 $name2",
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navigator.pop()
                }
            ){
                Text(
                    text = "Vamos para atras"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row {
                Button(
                    onClick = {
                        navigator.push(SecondScreen())
                    }
                ){
                    Text(
                        text = "Ir a la segunda página"
                    )
                }
                Spacer(
                    modifier = Modifier.width(20.dp)
                )
                Button(
                    onClick = {
                        navigator.push(ThirdScreen())
                    }
                ){
                    Text(
                        text = "Ir a la tercera página"
                    )
                }
            }

        }
    }
}

class SecondScreen: Screen{
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Segunda Pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ){
                Text(
                    text = "Vamos para atras"
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Row {
                Button(
                    onClick = {
                        navigator.push(MainScreen())
                    }
                ){
                    Text(
                        text = "Ir a la primera página"
                    )
                }
                Spacer(
                    modifier = Modifier.width(20.dp)
                )
                Button(
                    onClick = {
                        navigator.push(ThirdScreen())
                    }
                ){
                    Text(
                        text = "Ir a la tercera página"
                    )
                }
            }
        }

    }

}

class ThirdScreen: Screen{
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Tercera pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ){
                Text(
                    text = "Vamos para atras"
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Row {
                Button(
                    onClick = {
                        navigator.push(MainScreen())
                    }
                ){
                    Text(
                        text = "Ir a la primera página"
                    )
                }
                Spacer(
                    modifier = Modifier.width(20.dp)
                )
                Button(
                    onClick = {
                        navigator.push(SecondScreen())
                    }
                ){
                    Text(
                        text = "Ir a la segunda página"
                    )
                }
                Spacer(
                    modifier = Modifier.width(20.dp)
                )

                Button(
                    onClick = {
                        navigator.push(
                            item = BottomBarScreen(),
                        )
                    }
                ){
                    Text(
                        text = "Ir a la BottomBar"
                    )
                }

            }

        }

    }

}