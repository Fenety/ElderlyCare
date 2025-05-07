package com.example.elderlycare.data.model

data class SignUpRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val role: String
)