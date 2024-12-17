package com.raulastete.kambio.domain.entity

import java.math.BigDecimal

data class ExchangeTransaction(
    val id: String,
    val originAccount: Account,
    val destinationAccount: Account,
    val exchangeDetails: ExchangeDetails,
    val exchangeConfirmation: ExchangeConfirmation
)

data class ExchangeDetails(
    val exchangeRate: ExchangeRate,
    val originalAmount: CurrencyAmount,
    val changedAmount: CurrencyAmount,
)

data class CurrencyAmount(
    val currency: Currency,
    val amount: BigDecimal
)

data class ExchangeRate(
    val exchangeType: ExchangeType,
    val value: Double
)

data class ExchangeConfirmation(
    val timestamp: Long,
    val code: String
)