package com.raulastete.kambio.presentation.home

sealed interface HomeAction {
    data object ChangeExchangeType : HomeAction
    data object ShowCouponCode : HomeAction
    data object SendCouponCode : HomeAction
    data object StartOperation: HomeAction
}