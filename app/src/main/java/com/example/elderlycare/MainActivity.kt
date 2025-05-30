package com.example.elderlycare
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.elderlycare.ui.theme.ElderlyCareTheme
import com.example.elderlycare.presentation.navigation.MainNavigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElderlyCareTheme {
                val navController = rememberNavController()
                MainNavigation(navController)
            }
        }
    }
}
