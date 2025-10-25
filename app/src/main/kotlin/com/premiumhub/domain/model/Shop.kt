// File: Shop.kt
package com.premiumhub.domain.model

data class Shop(
    val id: Int = 0,
    val name: String,
    val type: String,
    val address: String? = null,
    val phone: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)