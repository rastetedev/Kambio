package com.raulastete.kambio.domain.entity

data class Account(
    val id: String,
    val alias: String,
    val bankName: String,
    val accountType: AccountType,
    val currency: Currency
)