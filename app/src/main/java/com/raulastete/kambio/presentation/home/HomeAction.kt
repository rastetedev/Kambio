package com.raulastete.kambio.presentation.home

sealed interface HomeAction {
    data object ChangeExchangeType : HomeAction
    data object SendCouponCode : HomeAction
}