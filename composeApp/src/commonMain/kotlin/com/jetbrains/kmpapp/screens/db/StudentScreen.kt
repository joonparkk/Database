package com.jetbrains.kmpapp.screens.db

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.dokar.sonner.rememberToasterState
import kotlinx.coroutines.runBlocking
import org.lighthousegames.logging.logging
import kotlin.math.roundToInt

data object StudentScreen : Screen {
  @Composable
  override fun Content() {
    val log = logging()
    var email by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf(0) }
    var phoneNumber by remember { mutableStateOf("") }
    val toast = rememberToasterState()

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = firstName, onValueChange = { firstName = it }, label = { Text("First Name") })
        TextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Last Name") })
        Text("Grade: $grade (-1 is PK, 0 is K, 13 is College")
        Slider(value = grade.toFloat(), valueRange = -1f..13f, onValueChange = { grade = it.roundToInt() })
        TextField(value = phoneNumber, onValueChange = { phoneNumber = it }, label = { Text("Phone Number") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })

        Button({
          val viewModel = StudentViewModel()
          runBlocking {
            log.info { "Adding student $firstName $lastName $grade $phoneNumber $email" }
            viewModel.addStudent(Student(firstName, lastName, grade, phoneNumber, email))
              .onSuccess { toast.show(it) }
              .onFailure { toast.show(it.message ?: "Error adding user") }
          }
        }) {
          Text("Add User")
        }
      }
    }
  }
}