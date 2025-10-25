// File: NotificationEntity.kt
package com.premiumhub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class NotificationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val message: String,
    val type: String, // "SIGNUP_REQUEST", "LOW_STOCK", "SALES_UPLOADED"
    val isRead: Boolean = false,
    val targetUserId: Int? = null, // Admin user ID
    val relatedId: Int? = null, // Related entity ID (user, stock, etc.)
    val createdAt: Long = System.currentTimeMillis()
)