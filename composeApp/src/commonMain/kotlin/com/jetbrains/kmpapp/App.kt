package com.jetbrains.kmpapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.jetbrains.kmpapp.screens.db.StudentScreen
import org.lighthousegames.logging.logging

@Suppress("FunctionName")
@Composable
fun App() {
  val log = logging()
  log.info {"App()"}
  MaterialTheme {
        Navigator(StudentScreen)
    }
}
