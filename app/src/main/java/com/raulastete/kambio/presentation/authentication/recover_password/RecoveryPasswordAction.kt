package com.raulastete.kambio.presentation.authentication.recover_password

sealed interface RecoveryPasswordAction {

    data object NavigateBack: RecoveryPasswordAction
    data object SendEmail: RecoveryPasswordAction
}