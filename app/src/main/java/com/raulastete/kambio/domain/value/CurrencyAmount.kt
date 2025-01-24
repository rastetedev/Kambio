package com.raulastete.kambio.domain.value

import com.raulastete.kambio.domain.entity.Currency
import java.math.BigDecimal

data class CurrencyAmount(
    val currency: Currency,
    val amount: BigDecimal
)