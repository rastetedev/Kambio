package com.raulastete.kambio.domain.entity

import com.raulastete.kambio.domain.value.ExchangeConfirmation
import com.raulastete.kambio.domain.value.ExchangeDetails

data class ExchangeTransaction(
    val id: String,
    val originAccount: Account,
    val destinationAccount: Account,
    val exchangeDetails: ExchangeDetails,
    val exchangeConfirmation: ExchangeConfirmation
)