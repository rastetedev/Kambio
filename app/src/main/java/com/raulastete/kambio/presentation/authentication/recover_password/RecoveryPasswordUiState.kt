package com.raulastete.kambio.presentation.authentication.recover_password

import androidx.compose.foundation.text.input.TextFieldState

data class RecoveryPasswordUiState(
    val email: TextFieldState = TextFieldState(),
    val canSendEmail: Boolean = false,
    val isSendingEmail: Boolean = false
)