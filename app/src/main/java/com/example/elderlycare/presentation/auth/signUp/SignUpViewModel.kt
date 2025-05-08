package com.example.elderlycare.presentation.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elderlycare.data.model.SignUpRequest
import com.example.elderlycare.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _signUpSuccess = MutableStateFlow(false)
    val signUpSuccess: StateFlow<Boolean> = _signUpSuccess

    private val _fullName = MutableStateFlow("")
    val fullName: StateFlow<String> = _fullName

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword

    private val _selectedRole = MutableStateFlow("Care Taker") // Default role
    val selectedRole: StateFlow<String> = _selectedRole

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onFullNameChange(value: String) {
        _fullName.value = value
    }

    fun onEmailChange(value: String) {
        _email.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun onConfirmPasswordChange(value: String) {
        _confirmPassword.value = value
    }

    fun onRoleSelected(role: String) {
        _selectedRole.value = role
    }

    fun onSignUpClick() {
        if (password.value != confirmPassword.value) {
            // TODO: Show password mismatch error
            return
        }


        viewModelScope.launch {
            _isLoading.value = true

            val request = SignUpRequest(
                fullName = fullName.value,
                email = email.value,
                password = password.value,
                role = selectedRole.value
            )

            val success = repository.signUp(request)
            _signUpSuccess.value = success


            // TODO: Show result message or navigate
            _isLoading.value = false
        }
    }
}