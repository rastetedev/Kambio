package com.raulastete.kambio.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel constructor() : ViewModel() {

    var state by mutableStateOf(HomeUiState())
        private set

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.ChangeExchangeType -> TODO()
            HomeAction.SendCouponCode -> TODO()
        }
    }
}