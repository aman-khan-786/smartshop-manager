// File: SalesEntity.kt
package com.premiumhub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class SalesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val shopName: String,
    val shopId: Int,
    val staffName: String,
    val staffEmail: String,
    val totalSales: Double,
    val cashSales: Double,
    val onlineSales: Double,
    val date: String, // Format: "yyyy-MM-dd"
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)