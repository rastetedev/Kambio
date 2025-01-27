package com.raulastete.kambio.domain.usecase

import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.repository.ExchangeRateRepository
import java.math.BigDecimal
import java.math.RoundingMode

class GetExchangeFactorForCurrencies(
    private val exchangeRateRepository: ExchangeRateRepository
) {

    suspend operator fun invoke(
        originCurrency: Currency,
        destinationCurrency: Currency,
        exchangeType: ExchangeType
    ): BigDecimal {

        check(originCurrency != destinationCurrency)

        val exchangeRates = exchangeRateRepository.getExchangeRatesFor(exchangeType)

        val originExchangeRate = exchangeRates.firstOrNull {
            it.currency == originCurrency
        }

        val destinationExchangeRate = exchangeRates.firstOrNull {
            it.currency == destinationCurrency
        }

        if (originExchangeRate != null && destinationExchangeRate != null) {
            return originExchangeRate.value.divide(destinationExchangeRate.value,  2, RoundingMode.CEILING)
        }

        throw IllegalStateException("Origin or destination currency not found")
    }
}