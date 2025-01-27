package com.raulastete.kambio.domain.usecase

import java.math.BigDecimal

class TransformCalculationToInputAmount {

    suspend operator fun invoke(calculationAmount: BigDecimal): String {
        if(calculationAmount == BigDecimal.ZERO) return "0"
        return calculationAmount.multiply(100.toBigDecimal()).toInt().toString()
    }
}