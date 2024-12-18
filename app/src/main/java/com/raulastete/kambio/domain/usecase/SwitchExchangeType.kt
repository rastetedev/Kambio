package com.raulastete.kambio.domain.usecase

import com.raulastete.kambio.domain.entity.ExchangeDetails
import com.raulastete.kambio.domain.entity.ExchangeRate
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.reponsitory.ExchangeRateRepository

/*class SwitchExchangeType(
    private val exchangeRateRepository: ExchangeRateRepository
) {

    suspend operator fun invoke(
        exchangeDetails: ExchangeDetails
    ): ExchangeDetails {

        val currentExchangeRates = exchangeRateRepository.getCurrentExchangeRates()

        return when (exchangeDetails.exchangeRate.exchangeType) {
            ExchangeType.SELL -> {
                *//*exchangeDetails.copy(
                    exchangeRate = ExchangeRate(
                        exchangeType = ExchangeType.BUY,
                        value = currentExchangeRates.get(ExchangeType.BUY) ?: 0.0
                    ),
                    originalAmount =,
                    changedAmount =,
                )*//*
            }

            ExchangeType.BUY -> {
                *//*ExchangeDetails(
                    exchangeRate = ExchangeRate(
                        exchangeType = ExchangeType.SELL,
                        value = currentExchangeRates.get(ExchangeType.SELL) ?: 0.0
                    ),
                    originalAmount =,
                    changedAmount =,
                )*//*
            }
        }
    }
}*/
