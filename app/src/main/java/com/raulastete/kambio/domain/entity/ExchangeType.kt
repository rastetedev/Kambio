package com.raulastete.kambio.domain.entity

enum class ExchangeType {
    BUY, SELL;

    val isBuy: Boolean
        get() = this == BUY
}