package com.raulastete.kambio.di

import com.raulastete.kambio.presentation.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(
            getConvertedAmount = get(),
            dispatcher = get(named("MainDispatcher"))
        )
    }
}