package com.raulastete.kambio.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(HomeUiState())
        private set

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.ChangeExchangeType -> {
                state = state.copy(exchangeType = state.exchangeType.opposite())
            }
            HomeAction.ShowCouponCode -> {
                state = state.copy(showCouponCodeInput = true)
            }
            HomeAction.SendCouponCode -> {}
            HomeAction.StartOperation -> {}
        }
    }
}