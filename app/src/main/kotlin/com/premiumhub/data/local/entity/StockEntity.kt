// File: StockEntity.kt
package com.premiumhub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stocks")
data class StockEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val itemName: String,
    val quantity: Int,
    val category: String,
    val shopId: Int,
    val addedBy: String, // User email
    val dateAdded: Long = System.currentTimeMillis(),
    val lastUpdated: Long = System.currentTimeMillis(),
    val minStockLevel: Int = 5 // Low stock threshold
)