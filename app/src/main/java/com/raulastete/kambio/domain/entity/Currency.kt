package com.raulastete.kambio.domain.entity

sealed class Currency(val symbol: String) {
    data object PeruvianSol : Currency("S/")

    data object Dollar : Currency("$")
}