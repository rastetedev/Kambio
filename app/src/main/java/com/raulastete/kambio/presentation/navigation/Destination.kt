package com.raulastete.kambio.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object Login : Destination
    @Serializable
    data object Registration : Destination
    @Serializable
    data object RecoverPassword : Destination
    @Serializable
    data object Home : Destination
    @Serializable
    data object TransactionValidation : Destination
}