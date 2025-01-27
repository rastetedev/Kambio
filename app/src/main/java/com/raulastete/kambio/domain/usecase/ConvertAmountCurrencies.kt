package com.raulastete.kambio.domain.usecase

import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.value.CurrencyAmount
import com.raulastete.kambio.domain.entity.ExchangeType
import java.math.BigDecimal

class ConvertAmountCurrencies(
    private val getExchangeFactorForCurrencies: GetExchangeFactorForCurrencies
) {

    suspend operator fun invoke(
        originCurrencyAmount: CurrencyAmount,
        destinationCurrency: Currency,
        exchangeType: ExchangeType
    ): BigDecimal {

        check(originCurrencyAmount.currency != destinationCurrency)

        val exchangeFactor = getExchangeFactorForCurrencies(
            originCurrencyAmount.currency,
            destinationCurrency,
             exchangeType
        )

        return exchangeFactor.multiply(originCurrencyAmount.amount)
    }
}