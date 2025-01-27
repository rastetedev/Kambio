package com.raulastete.kambio.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raulastete.kambio.domain.usecase.GetConvertedAmount
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getConvertedAmount: GetConvertedAmount,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    var state by mutableStateOf(HomeUiState())
        private set

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.ChangeExchangeType -> {
                state = state.copy(exchangeType = state.exchangeType.opposite())
                viewModelScope.launch(dispatcher){
                    val destinationAmount = getConvertedAmount(
                        fromAmount = state.originAmount,
                        fromCurrency = state.exchangeType.originCurrency,
                        toCurrency = state.exchangeType.destinationCurrency,
                        exchangeType = state.exchangeType
                    )
                    state = state.copy(destinationAmount = destinationAmount)
                }
            }

            is HomeAction.UpdateOriginAmount -> {
                state = state.copy(
                    originAmount = action.originAmount,
                )
                viewModelScope.launch(dispatcher){
                    val destinationAmount = getConvertedAmount(
                        fromAmount = state.originAmount,
                        fromCurrency = state.exchangeType.originCurrency,
                        toCurrency = state.exchangeType.destinationCurrency,
                        exchangeType = state.exchangeType
                    )
                    state = state.copy(destinationAmount = destinationAmount)
                }
            }

            is HomeAction.UpdateDestinationAmount -> {
                state = state.copy(
                    destinationAmount = action.destinationAmount,
                )
                viewModelScope.launch(dispatcher){
                    val originAmount = getConvertedAmount(
                        fromAmount = state.destinationAmount,
                        fromCurrency = state.exchangeType.destinationCurrency,
                        toCurrency = state.exchangeType.originCurrency,
                        exchangeType = state.exchangeType
                    )
                    state = state.copy(originAmount = originAmount)
                }
            }


            HomeAction.ShowCouponCode -> {
                state = state.copy(showCouponCodeInput = true)
            }

            HomeAction.SendCouponCode -> {

            }

            HomeAction.StartOperation -> {

            }

        }
    }
}