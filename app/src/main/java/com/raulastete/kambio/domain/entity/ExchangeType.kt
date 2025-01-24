package com.raulastete.kambio.domain.entity

enum class ExchangeType {
    BUY, SELL;

    val isBuy: Boolean
        get() = this == BUY

    val isSell: Boolean
        get() = this == SELL

    fun opposite() = when (this) {
        BUY -> SELL
        SELL -> BUY
    }

}