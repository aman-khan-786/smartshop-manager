// File: ShopEntity.kt
package com.premiumhub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shops")
data class ShopEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val type: String, // "MOBILE_SHOP" or "REPAIR_CENTER"
    val address: String? = null,
    val phone: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)