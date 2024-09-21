package com.example.agrosupportv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agrosupportv2.presentation.ForgotPasswordScreen
import com.example.agrosupportv2.presentation.LoginScreen
import com.example.agrosupportv2.presentation.WelcomeScreen
import com.example.agrosupportv2.ui.theme.AgroSupportV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgroSupportV2Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen(navController) }
                    composable("login") { LoginScreen(navController) }
                    composable("forgotPassword") { ForgotPasswordScreen(navController) }
                }
            }
        }
    }
}