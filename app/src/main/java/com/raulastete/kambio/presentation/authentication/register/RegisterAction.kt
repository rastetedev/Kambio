package com.raulastete.kambio.presentation.authentication.register

sealed interface RegisterAction {
    data object TogglePasswordVisibility: RegisterAction
    data object TogglePasswordConfirmationVisibility: RegisterAction
    data object RegisterClick: RegisterAction
    data object LoginClick: RegisterAction
    data object NavigateBack: RegisterAction
}