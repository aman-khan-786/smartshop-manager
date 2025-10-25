// File: FirebaseSales.kt
package com.premiumhub.data.remote.models

data class FirebaseSales(
    val id: String = "",
    val shopName: String = "",
    val shopId: String = "",
    val staffName: String = "",
    val staffEmail: String = "",
    val totalSales: Double = 0.0,
    val cashSales: Double = 0.0,
    val onlineSales: Double = 0.0,
    val date: String = "",
    val notes: String? = null,
    val createdAt: Long = 0
)