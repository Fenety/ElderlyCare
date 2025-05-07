package com.example.elderlycare.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.elderlycare.R
import com.example.elderlycare.ui.theme.*
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(BackgroundColor),
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
            text = "Login",
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField("Email*", email) { viewModel.onEmailChange(it) }
        AppTextField("Password*", password, isPassword = true) { viewModel.onPasswordChange(it) }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // TODO: Handle login logic
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
        ) {
            Text("Login", color = ButtonTextColor)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text("Don't have an account? ", color = TextColor)
            Text(
                "Sign Up",
                color = PrimaryColor,
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                }
            )
        }
    }
}

@Composable
fun AppTextField(
    label: String,
    value: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    val visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp)) {
        Text(
            text = label,
            color = TextColor,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            shape = MaterialTheme.shapes.medium,
            visualTransformation = visualTransformation,
            singleLine = true,
            placeholder = { Text(text = label.replace("*", "")) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = TextFieldBackground,
                unfocusedContainerColor = TextFieldBackground,
                focusedTextColor = TextColor,
                unfocusedTextColor = TextColor,
                focusedBorderColor = BorderFocusedColor,
                unfocusedBorderColor = BorderUnfocusedColor,
                cursorColor = TextColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun LoginScreenPreview() {
    ElderlyCareTheme {
        val navController = rememberNavController()
        LoginScreen(navController = navController)
    }
}
