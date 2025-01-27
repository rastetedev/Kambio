package com.raulastete.kambio.data.repository

import com.raulastete.kambio.domain.entity.Buy
import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.repository.ExchangeRateRepository
import com.raulastete.kambio.domain.value.ExchangeRate
import java.math.BigDecimal

class DefaultExchangeRateRepository : ExchangeRateRepository {

    override suspend fun getExchangeRatesFor(exchangeType: ExchangeType): List<ExchangeRate> {
        return if(exchangeType is Buy)
        listOf(
            ExchangeRate(
                currency = Currency.PeruvianSol,
                value = 1.toBigDecimal(),
                exchangeType = exchangeType
            ),
            ExchangeRate(
                currency = Currency.Dollar,
                value = BigDecimal.valueOf(3.71),
                exchangeType = exchangeType
            )
        ) else {
            return listOf(
                ExchangeRate(
                    currency = Currency.PeruvianSol,
                    value = 0.27.toBigDecimal(),
                    exchangeType = exchangeType
                ),
                ExchangeRate(
                    currency = Currency.Dollar,
                    value = BigDecimal.valueOf(1),
                    exchangeType = exchangeType
                )
            )
        }
    }
}