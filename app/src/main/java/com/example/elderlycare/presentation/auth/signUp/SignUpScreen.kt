package com.example.elderlycare.presentation.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.elderlycare.R
import com.example.elderlycare.ui.theme.*
import kotlinx.coroutines.flow.collect
/*import androidx.compose.runtime.livedata.observeAsState*/
import androidx.compose.runtime.LaunchedEffect
import com.example.elderlycare.presentation.auth.login.AppTextField


@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = viewModel()
) {
    val fullName by viewModel.fullName.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()
    val selectedRole by viewModel.selectedRole.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val signUpSuccess by viewModel.signUpSuccess.collectAsState()

    // Navigate on successful signup
    LaunchedEffect(signUpSuccess) {
        if (signUpSuccess) {
            navController.navigate("login") {
                popUpTo("signup") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = PrimaryColor
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Care Taker", "Nurse").forEach { role ->
                Button(
                    onClick = { viewModel.onRoleSelected(role) },
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedRole == role) PrimaryColor else TextFieldBackground,
                        contentColor = if (selectedRole == role) ButtonTextColor else TextColor
                    ),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .width(160.dp)
                        .height(55.dp)
                ) {
                    Text(role, fontSize = 20.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField("Full Name*", fullName) { viewModel.onFullNameChange(it) }
        AppTextField("Email*", email) { viewModel.onEmailChange(it) }
        AppTextField("Password*", password, isPassword = true) { viewModel.onPasswordChange(it) }
        AppTextField("Confirm Password*", confirmPassword, isPassword = true) { viewModel.onConfirmPasswordChange(it) }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.onSignUpClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !isLoading,
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = ButtonTextColor, modifier = Modifier.size(24.dp))
            } else {
                Text("Create Account", color = ButtonTextColor)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}