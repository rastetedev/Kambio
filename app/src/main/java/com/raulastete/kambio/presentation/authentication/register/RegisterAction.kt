package com.raulastete.kambio.presentation.authentication.register

sealed interface RegisterAction {
    data object OnTogglePasswordVisibility: RegisterAction
    data object OnTogglePasswordConfirmationVisibility: RegisterAction
    data object OnRegisterClick: RegisterAction
    data object OnLoginClick: RegisterAction
    data object OnNavigateBack: RegisterAction
}