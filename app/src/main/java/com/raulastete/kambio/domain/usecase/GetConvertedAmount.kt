package com.raulastete.kambio.domain.usecase

import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.domain.value.CurrencyAmount
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetConvertedAmount(
    private val transformInputAmountToCalculation: TransformInputAmountToCalculation,
    private val convertAmountCurrencies: ConvertAmountCurrencies,
    private val transformCalculationToInputAmount: TransformCalculationToInputAmount,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        fromAmount: String,
        fromCurrency: Currency,
        toCurrency: Currency,
        exchangeType: ExchangeType
    ) : String {
       return withContext(dispatcher){
            val fromAmountToCalculation =
                transformInputAmountToCalculation(fromAmount)
            val toAmountCalculated = convertAmountCurrencies(
                originCurrencyAmount = CurrencyAmount(
                    currency = fromCurrency,
                    amount = fromAmountToCalculation
                ),
                destinationCurrency = toCurrency,
                exchangeType = exchangeType
            )
           transformCalculationToInputAmount(toAmountCalculated)
        }
    }
}