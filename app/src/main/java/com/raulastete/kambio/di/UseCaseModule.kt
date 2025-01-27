package com.raulastete.kambio.di

import com.raulastete.kambio.domain.usecase.ConvertAmountCurrencies
import com.raulastete.kambio.domain.usecase.GetConvertedAmount
import com.raulastete.kambio.domain.usecase.GetExchangeFactorForCurrencies
import com.raulastete.kambio.domain.usecase.TransformCalculationToInputAmount
import com.raulastete.kambio.domain.usecase.TransformInputAmountToCalculation
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {

    factory {
        GetConvertedAmount(
            transformInputAmountToCalculation = get(),
            convertAmountCurrencies = get(),
            transformCalculationToInputAmount = get(),
            dispatcher = get(named("DefaultDispatcher"))
        )
    }
    factoryOf(::GetExchangeFactorForCurrencies)
    factoryOf(::ConvertAmountCurrencies)
    factoryOf(::TransformInputAmountToCalculation)
    factoryOf(::TransformCalculationToInputAmount)
}