package com.raulastete.kambio.presentation.home

import com.raulastete.kambio.domain.entity.Buy
import com.raulastete.kambio.domain.entity.ExchangeType
import java.math.BigDecimal

data class HomeUiState(
    val exchangeType: ExchangeType = Buy(),
    val savingAmount: BigDecimal = BigDecimal.valueOf(0),
    val originAmount: String = "",
    val destinationAmount: String = "",
    val showCouponCodeInput: Boolean = false
)