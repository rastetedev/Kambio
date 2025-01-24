package com.raulastete.kambio.domain.repository

import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.value.ExchangeRate


interface ExchangeRateRepository {

   suspend fun getExchangeRatesFor(exchangeType: ExchangeType) : List<ExchangeRate>

}