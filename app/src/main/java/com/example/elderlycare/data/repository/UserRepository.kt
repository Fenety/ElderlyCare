package com.example.elderlycare.data.repository

import com.example.elderlycare.data.model.LoginRequest
import com.example.elderlycare.data.model.SignUpRequest
import com.example.elderlycare.data.network.AuthService
import data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    private val api: AuthService = RetrofitClient.apiService

    suspend fun login(request: LoginRequest): Boolean = withContext(Dispatchers.IO) {
        try {
            val response = api.login(request)
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    suspend fun signUp(request: SignUpRequest): Boolean = withContext(Dispatchers.IO) {
        try {
            val response = api.signUp(request)
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }
}