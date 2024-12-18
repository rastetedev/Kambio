package com.raulastete.kambio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.raulastete.kambio.presentation.authentication.login.LoginScreen
import com.raulastete.kambio.ui.theme.KambioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
               false
            }
        }
        enableEdgeToEdge()
        setContent {
            KambioTheme {
                LoginScreen()
            }
        }
    }
}