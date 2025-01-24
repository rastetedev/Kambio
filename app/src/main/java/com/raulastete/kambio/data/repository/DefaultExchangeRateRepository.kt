package com.raulastete.kambio.data.repository

import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.repository.ExchangeRateRepository
import com.raulastete.kambio.domain.value.ExchangeRate

class DefaultExchangeRateRepository : ExchangeRateRepository {

    override suspend fun getExchangeRatesFor(exchangeType: ExchangeType): List<ExchangeRate> {
        return emptyList()
    }
}