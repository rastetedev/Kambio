package com.raulastete.kambio.domain.usecase

import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.value.CurrencyAmount
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.repository.ExchangeRateRepository

class ConvertAmountCurrencies(
    private val exchangeRateRepository: ExchangeRateRepository,
    private val getExchangeFactorForCurrencies: GetExchangeFactorForCurrencies
) {

    suspend operator fun invoke(
        originCurrencyAmount: CurrencyAmount,
        destinationCurrency: Currency,
        exchangeType: ExchangeType
    ): CurrencyAmount {

        check(originCurrencyAmount.currency != destinationCurrency)

        val exchangeFactor = getExchangeFactorForCurrencies(
            originCurrencyAmount.currency,
            destinationCurrency,
            exchangeType
        )

        return CurrencyAmount(
            currency = destinationCurrency,
            amount = exchangeFactor.multiply(originCurrencyAmount.amount)
        )
    }
}