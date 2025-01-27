package com.raulastete.kambio.di

import org.koin.dsl.module

val kambioAppModule = module {
    includes(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        dispatchersModule
    )
}