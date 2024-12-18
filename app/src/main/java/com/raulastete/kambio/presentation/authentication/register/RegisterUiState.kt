package com.raulastete.kambio.presentation.authentication.register

import androidx.compose.foundation.text.input.TextFieldState

data class RegisterUiState(
    val email: TextFieldState = TextFieldState(),
    val emailConfirmation : TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val passwordConfirmation: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val isPasswordConfirmationVisible: Boolean = false,
    val canRegister: Boolean = false,
    val isRegistering: Boolean = false
)