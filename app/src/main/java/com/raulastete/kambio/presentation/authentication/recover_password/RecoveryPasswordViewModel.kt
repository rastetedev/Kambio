package com.raulastete.kambio.presentation.authentication.recover_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class RecoveryPasswordViewModel constructor() : ViewModel() {

    var state by mutableStateOf(RecoveryPasswordUiState())
        private set

    fun onAction(action: RecoveryPasswordAction) {

    }
}