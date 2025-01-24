package com.raulastete.kambio.domain.value

import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.ExchangeType
import java.math.BigDecimal

data class ExchangeRate(
    val currency: Currency,
    val exchangeType: ExchangeType,
    val value: BigDecimal
)