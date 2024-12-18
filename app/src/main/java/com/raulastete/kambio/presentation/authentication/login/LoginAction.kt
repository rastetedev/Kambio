package com.raulastete.kambio.presentation.authentication.login

sealed interface LoginAction {
    data object OnTogglePasswordVisibility: LoginAction
    data object OnLoginClick: LoginAction
    data object OnRegisterClick: LoginAction
    data object OnRecoverPasswordClick: LoginAction
}