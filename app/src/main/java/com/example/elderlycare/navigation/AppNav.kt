package com.example.elderlycare.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elderlycare.presentation.auth.LandingPage
import com.example.elderlycare.presentation.auth.login.LoginScreen
import com.example.elderlycare.presentation.auth.signup.SignUpScreen


object Routes {
    const val LANDING = "landing"
    const val SIGN_UP = "signup"
    const val LOGIN = "login"
}

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LANDING) {

        composable(Routes.LANDING) {
            LandingPage(
                navController = navController
            )
        }

        composable(Routes.SIGN_UP) {
            SignUpScreen(
                onLogin = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onSignUp = {
                    navController.navigate(Routes.SIGN_UP)
                }
            )
        }
    }
}
