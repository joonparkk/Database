package com.jetbrains.kmpapp.screens.db

import io.ktor.client.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

/**
 * Asynchronously adds a new student to the database.
 *
 * This function constructs a JSON object with the student's details and sends it to a specified
 * endpoint using HTTP POST. It uses Ktor's HttpClient configured with Digest authentication
 * for secure communication. The function returns an HttpResponse object which can be used
 * to check the status of the request.
 *
 * @param firstName The first name of the student.
 * @param lastName The last name of the student.
 * @param grade The grade of the student as an integer.
 * @param phoneNumber The phone number of the student, nullable.
 * @param email The email address of the student, nullable.
 * @return HttpResponse The response from the server after attempting to add the student.
 * @throws Exception if the request fails due to network issues or server errors.
 */
suspend fun addStudent(
  firstName: String,
  lastName: String,
  grade: Int,
  phoneNumber: String?,
  email: String?
): HttpResponse {
  val client = HttpClient {
    install(Auth) {
      digest {
        credentials {
          DigestAuthCredentials("81DSC210", "82b77e98-9ba4-4755-829a-3813a1750800")
        }
      }
    }
  }

  val requestBody = buildJsonObject {
    put("first_name", firstName)
    put("last_name", lastName)
    put("grade", grade)
    put("phone_number", phoneNumber ?: "")
    put("email", email ?: "")
  }.toString()

  val response: HttpResponse =
    client.post("https://us-east-1.data.tidbcloud.com/api/v1beta/app/dataapp-NNWyDyFN/endpoint/students") {
      header(HttpHeaders.ContentType, ContentType.Application.Json)
      setBody(TextContent(requestBody, ContentType.Application.Json))
    }

  return response
}