package com.raulastete.kambio.domain.reponsitory

import com.raulastete.kambio.domain.entity.ExchangeRate
import com.raulastete.kambio.domain.entity.ExchangeType
import kotlinx.coroutines.flow.Flow

interface ExchangeRateRepository {

    suspend fun getCurrentExchangeRates(): Map<ExchangeType, Double>

    fun observeExchangeRates(): Flow<List<ExchangeRate>>
}