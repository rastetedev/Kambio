package com.raulastete.kambio.presentation.authentication.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {

    var state by mutableStateOf(RegisterUiState())
        private set

    fun onAction(action: RegisterAction) {
        when (action) {
            else -> {}
        }
    }
}