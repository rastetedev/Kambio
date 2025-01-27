package com.raulastete.kambio.domain.entity

sealed class ExchangeType {

    abstract val originCurrency: Currency
    abstract val destinationCurrency: Currency
    val savingEstimationCurrency: Currency = destinationCurrency

    fun opposite() = when (this) {
        is Buy -> Sell()
        is Sell -> Buy()
    }
    fun isBuy() = this is Buy
    fun isSell() = this is Sell
}

class Buy : ExchangeType() {
    override val originCurrency: Currency
        get() = Currency.Dollar
    override val destinationCurrency: Currency
        get() = Currency.PeruvianSol
}

class Sell : ExchangeType() {
    override val originCurrency: Currency
        get() = Currency.PeruvianSol
    override val destinationCurrency: Currency
        get() = Currency.Dollar
}
