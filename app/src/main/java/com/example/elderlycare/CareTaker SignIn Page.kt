package com.example.elderlycare

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.elderlycare.ui.theme.*

@Composable
fun SignUpScreen() {
    var selectedRole by remember { mutableStateOf("Care Taker") }

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sign UP",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RoleButton("Care Taker", selectedRole == "Care Taker") {
                selectedRole = "Care Taker"
            }
            RoleButton("Nurse", selectedRole == "Nurse") {
                selectedRole = "Nurse"
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        SignUpTextField("Full Name*", "Enter your Full Name", fullName) { fullName = it }
        SignUpTextField("Email*", "Enter your Email", email) { email = it }
        SignUpTextField("Password*", "Create Password", password, true) { password = it }
        SignUpTextField(
            "Confirm Password*",
            "Password must match",
            confirmPassword,
            true
        ) { confirmPassword = it }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Handle account creation */ },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text("Create Account", color = ButtonTextColor, fontSize = 21.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text("Already have an account? ", color = TextColor)
            Text(
                "Login",
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { /* Navigate to Login */ }
            )
        }
    }
}

@Composable
fun RoleButton(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) PrimaryColor else TextFieldBackground,
            contentColor = if (isSelected) ButtonTextColor else TextColor
        ),
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .width(160.dp)
            .height(55.dp)
    ) {
        Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SignUpTextField(
    label: String,
    placeholder: String,
    value: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    val visualTransformation =
        if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
        Text(
            text = label,
            color = TextColor,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(placeholder) },
            visualTransformation = visualTransformation,
            singleLine = true,
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
fun SignUpScreenPreview() {
    ElderlyCareTheme {
        SignUpScreen()
    }
}
