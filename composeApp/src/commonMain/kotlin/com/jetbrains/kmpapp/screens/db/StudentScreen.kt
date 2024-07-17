package com.jetbrains.kmpapp.screens.db

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.dokar.sonner.rememberToasterState
import kotlinx.coroutines.runBlocking

data object StudentScreen: Screen {
  @Composable
  override fun Content() {
    var email by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf(0) }
    var phoneNumber by remember { mutableStateOf("") }
    val toast = rememberToasterState()

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = firstName, onValueChange = { firstName = it }, label = { Text("First Name") })
        TextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Last Name") })
        Text("Grade: $grade")
        IntegerSlider(value = grade, valueRange = 1..12, onValueChange = { grade = it })
        TextField(value = phoneNumber, onValueChange = { phoneNumber = it }, label = { Text("Phone Number") })

        Button(onClick = {
          val viewModel = AddStudentViewModel()
          runBlocking {
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