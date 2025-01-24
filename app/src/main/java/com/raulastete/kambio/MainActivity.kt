package com.raulastete.kambio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raulastete.kambio.presentation.authentication.login.LoginScreen
import com.raulastete.kambio.presentation.authentication.recover_password.RecoveryPasswordScreen
import com.raulastete.kambio.presentation.authentication.register.RegisterScreen
import com.raulastete.kambio.presentation.home.HomeScreen
import com.raulastete.kambio.presentation.navigation.Destination
import com.raulastete.kambio.presentation.transaction.validation.TransactionValidationScreen
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
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Destination.Login
                ) {

                    composable<Destination.Login> {
                        LoginScreen(
                            navigateToRecoverPassword = {
                                navController.navigate(Destination.RecoverPassword)
                            },
                            navigateToRegister = {
                                navController.navigate(Destination.Registration)
                            },
                            navigateToHome = {
                                navController.navigate(Destination.Home)
                            }
                        )
                    }

                    composable<Destination.Registration> {
                        RegisterScreen(
                            navigateBack = {
                                navController.popBackStack()
                            },
                            navigateToLogin = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable<Destination.RecoverPassword> {
                        RecoveryPasswordScreen(
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable<Destination.Home> {
                        HomeScreen()
                    }

                    composable<Destination.TransactionValidation>{
                        TransactionValidationScreen {

                        }
                    }
                }
            }
        }
    }
}