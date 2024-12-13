package com.raulastete.kambio.domain.entity

import java.math.BigDecimal

data class Exchange(
    val id: String,
    val exchangeType: ExchangeType,
    val originAccount: Account,
    val destinationAccount: Account,
    val originalAmount: AmountCurrency,
    val changedAmount: AmountCurrency,
    val exchangeRate: ExchangeRate,
    val exchangeConfirmation: ExchangeConfirmation
)

data class AmountCurrency(
    val amount: BigDecimal,
    val currency: Currency
)

data class ExchangeRate(
    val exchangeType: ExchangeType,
    val exchangeRate: Double
)

enum class ExchangeType {
    BUY, SELL
}

data class ExchangeConfirmation(
    val timestamp: Long,
    val code: String
)