package com.raulastete.kambio.presentation.authentication.recover_password

sealed interface RecoveryPasswordAction {

    data object OnNavigateBack: RecoveryPasswordAction
    data object SendEmail: RecoveryPasswordAction
}