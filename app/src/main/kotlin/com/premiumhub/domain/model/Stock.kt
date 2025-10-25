// File: Stock.kt
package com.premiumhub.domain.model

data class Stock(
    val id: Int = 0,
    val itemName: String,
    val quantity: Int,
    val category: String,
    val shopId: Int,
    val addedBy: String,
    val dateAdded: Long = System.currentTimeMillis(),
    val lastUpdated: Long = System.currentTimeMillis(),
    val minStockLevel: Int = 5,
    val isLowStock: Boolean = quantity < minStockLevel
)