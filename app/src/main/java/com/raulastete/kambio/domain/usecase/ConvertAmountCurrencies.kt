package com.raulastete.kambio.domain.usecase

import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.CurrencyAmount
import com.raulastete.kambio.domain.entity.ExchangeRate
import com.raulastete.kambio.domain.entity.ExchangeType

class ConvertAmountCurrencies() {

    suspend operator fun invoke(
        currencyAmount: CurrencyAmount,
        exchangeRate: ExchangeRate
    ): CurrencyAmount {

        return when (exchangeRate.exchangeType) {
            ExchangeType.BUY -> {
                check(currencyAmount.currency == Currency.PeruvianSol)
                val amountToReceive =
                    currencyAmount.amount.div(exchangeRate.value.toBigDecimal())
                CurrencyAmount(amount = amountToReceive, currency = Currency.Dollar)
            }

            ExchangeType.SELL -> {
                check(currencyAmount.currency == Currency.Dollar)
                val amountToReceive =
                    currencyAmount.amount.multiply(exchangeRate.value.toBigDecimal())
                CurrencyAmount(amount = amountToReceive, currency = Currency.PeruvianSol)
            }
        }
    }
}

//Comprar Dolares:  Pago en soles, recibo dolares.  Los soles los divido con el tipo de cambio
//Vender Dolares: Pago en dolares, recibo soles. LOs dolares los multiplico con el tipo de cambio