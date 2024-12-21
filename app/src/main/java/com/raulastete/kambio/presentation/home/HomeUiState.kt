package com.raulastete.kambio.presentation.home

import com.raulastete.kambio.domain.entity.ExchangeType

data class HomeUiState(
    val exchangeType: ExchangeType = ExchangeType.BUY,
    val savingEstimation: String = "S/0.00"
) {

}