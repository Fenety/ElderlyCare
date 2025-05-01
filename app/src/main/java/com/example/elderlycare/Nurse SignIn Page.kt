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
import com.example.elderlycare.ui.theme.* // Ensure you have your custom colors defined here

@Composable
fun NurseSignUpScreen() {
    val backgroundColor = Color(0xFFCAE7E5)
    val selectedColor = Color(0xFF1D6A6E)
    val unselectedColor = Color.White

    var selectedRole by remember { mutableStateOf("Nurse") }

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
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
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RoleButton("Care Taker", selectedRole == "Care Taker", selectedColor, unselectedColor) {
                selectedRole = "Care Taker"
            }
            RoleButton("Nurse", selectedRole == "Nurse", selectedColor, unselectedColor) {
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
            colors = ButtonDefaults.buttonColors(containerColor = selectedColor),
            modifier = Modifier.fillMaxWidth()
                .height(70.dp)
        ) {
            Text("Create Account", color = Color.White, fontSize = 21.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text("Already have an account? ")
            Text("Login",
                color = selectedColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { /* Navigate to Login */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NurseSignUpScreenPreview() {
    MaterialTheme {
        NurseSignUpScreen()
    }
}
