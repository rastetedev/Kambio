package com.raulastete.kambio.presentation.transaction.validation

sealed interface ValidationAction {

    object NavigateBack : ValidationAction
}