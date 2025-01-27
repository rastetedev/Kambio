package com.raulastete.kambio.di

import com.raulastete.kambio.data.repository.DefaultExchangeRateRepository
import com.raulastete.kambio.domain.repository.ExchangeRateRepository
import org.koin.dsl.module

val repositoryModule = module{

    single<ExchangeRateRepository> {
        DefaultExchangeRateRepository()
    }
}