package com.jetbrains.kmpapp.screens.helloWorld

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jetbrains.kmpapp.screens.backg.*


data object HelloWorldScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Hello World")

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = { navigator.push(Screen1("Welcome to Screen 1.")) }) {
                        Text("Go to Screen 1")
                    }
                    Button(onClick = { navigator.push(Screen2("Welcome to Screen 2.")) }) {
                        Text("Go to Screen 2")
                    }
                    Button(onClick = { navigator.push(Screen3("Welcome to Screen 3.")) }) {
                        Text("Go to Screen 3")
                    }
                    Button(onClick = { navigator.push(Screen4("Welcome to Screen 4.")) }) {
                        Text("Go to Screen 4")
                    }
                }
            }
        }
    }
}
