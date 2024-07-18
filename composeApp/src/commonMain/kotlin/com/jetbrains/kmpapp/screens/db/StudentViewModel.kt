package com.jetbrains.kmpapp.screens.db

import io.ktor.client.statement.*
import io.ktor.http.*

class StudentViewModel {
  suspend fun addStudent(student: Student): Result<String> = try {
    val response = addStudent(student.firstName, student.lastName, student.grade, student.phoneNumber, student.email)
    if (response.status == HttpStatusCode.OK) {
      Result.success(response.bodyAsText())
    } else {
      Result.failure(Exception("Failed to add user"))
    }
  } catch (e: Exception) {
    Result.failure(e)
  }
}
