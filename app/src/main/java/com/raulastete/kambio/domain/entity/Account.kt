package com.raulastete.kambio.domain.entity

data class Account(
    val id: String,
    val alias: String,
    val bankName: String,
    val accountType: AccountType,
    val currency: Currency
)

enum class AccountType {
    SAVING, CHECKING
}

enum class Currency {
    DOLLAR, PERUVIAN_SOL
}