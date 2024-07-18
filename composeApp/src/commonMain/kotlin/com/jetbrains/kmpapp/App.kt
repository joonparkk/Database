package com.jetbrains.kmpapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.jetbrains.kmpapp.screens.db.StudentScreen
import io.github.oshai.kotlinlogging.KotlinLogging

@Composable
fun App() {
  val log = KotlinLogging.logger{}
  log.info { "App()" }
    MaterialTheme {
        Navigator(StudentScreen)
    }
}
