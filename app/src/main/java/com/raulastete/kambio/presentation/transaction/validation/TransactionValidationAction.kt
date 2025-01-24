package com.raulastete.kambio.presentation.transaction.validation

sealed interface TransactionValidationAction {

    object NavigateBack : TransactionValidationAction
}