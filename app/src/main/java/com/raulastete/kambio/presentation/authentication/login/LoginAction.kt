package com.raulastete.kambio.presentation.authentication.login

sealed interface LoginAction {
    data object TogglePasswordVisibility: LoginAction
    data object LoginClick: LoginAction
    data object RegisterClick: LoginAction
    data object RecoverPasswordClick: LoginAction
}