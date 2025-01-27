package com.raulastete.kambio.domain.usecase

import timber.log.Timber
import java.math.BigDecimal
import java.math.RoundingMode

class TransformInputAmountToCalculation {

    suspend operator fun invoke(originAmount: String): BigDecimal {

        return when {
            originAmount.isEmpty() || originAmount.startsWith("0") -> {
                Timber.d("Origin amount is empty or starts with 0")
                BigDecimal.ZERO
            }
            else -> {
                Timber.d("Origin amount Transformer: $originAmount")
                BigDecimal(originAmount).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
            }
        }
    }
}