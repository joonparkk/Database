package com.jetbrains.kmpapp.screens.db

/**
 * Represents a response structure for user-related operations.
 *
 * @property firstName The first name of the student.
 * @property lastName The last name of the student.
 * @property grade The grade of the student, which can be null if not specified.
 * @property phoneNumber The phone number of the student, which can be null if not specified.
 * @property email The email address of the student, which can be null if not specified.
 */
data class Student(
  val firstName: String,
  val lastName: String,
  val grade: Int,
  val phoneNumber: String?,
  val email: String?
)