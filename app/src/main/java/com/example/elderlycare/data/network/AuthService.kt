package com.example.elderlycare.data.network

import com.example.elderlycare.data.model.LoginRequest
import com.example.elderlycare.data.model.SignUpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<Any>

    @POST("/api/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): Response<Any>
}

// Example data classes for LoginRequest and SignUpRequest

data class LoginRequest(
    val email: String,
    val password: String
)

data class SignUpRequest(
    val email: String,
    val password: String,
    val fullName: String,
    val phoneNumber: String
)
