// File: Sales.kt
package com.premiumhub.domain.model

data class Sales(
    val id: Int = 0,
    val shopName: String,
    val shopId: Int,
    val staffName: String,
    val staffEmail: String,
    val totalSales: Double,
    val cashSales: Double,
    val onlineSales: Double,
    val date: String,
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)