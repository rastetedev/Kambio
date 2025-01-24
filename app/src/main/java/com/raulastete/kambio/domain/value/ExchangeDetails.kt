package com.raulastete.kambio.domain.value

data class ExchangeDetails(
    val exchangeRate: ExchangeRate,
    val originalAmount: CurrencyAmount,
    val changedAmount: CurrencyAmount,
)