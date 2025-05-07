package com.example.elderlycare.presentation.auth.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elderlycare.data.repository.UserRepository
import com.example.elderlycare.data.model.SignUpRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val userRepository: UserRepository = UserRepository()
) : ViewModel() {

    private val _fullName = MutableStateFlow("")
    val fullName: StateFlow<String> = _fullName

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword

    private var _selectedRole = MutableStateFlow("Care Taker")
    var selectedRole: StateFlow<String> = _selectedRole

    private val _signUpState = MutableStateFlow(false)
    val signUpState: StateFlow<Boolean> = _signUpState

    private val _signUpSuccess = MutableStateFlow(false)
    val signUpSuccess: StateFlow<Boolean> = _signUpSuccess

    fun onFullNameChange(newName: String) {
        _fullName.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirm: String) {
        _confirmPassword.value = newConfirm
    }

    fun onRoleSelected(role: String) {
        _selectedRole.value = role
    }



    fun signUp() {
        val request = SignUpRequest(
            fullName = fullName.value,
            email = email.value,
            password = password.value,
            role = selectedRole.value
        )

        viewModelScope.launch {
            val result = userRepository.signUp(request)
           _signUpState.value = result
            // change with signup success incase
        }
    }
}
