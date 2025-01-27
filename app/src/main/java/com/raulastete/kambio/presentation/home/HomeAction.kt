package com.raulastete.kambio.presentation.home

sealed interface HomeAction {
    data object ChangeExchangeType : HomeAction
    data object ShowCouponCode : HomeAction
    data object SendCouponCode : HomeAction
    data object StartOperation: HomeAction
    data class UpdateOriginAmount(val originAmount: String) : HomeAction
    data class UpdateDestinationAmount(val destinationAmount: String) : HomeAction
}