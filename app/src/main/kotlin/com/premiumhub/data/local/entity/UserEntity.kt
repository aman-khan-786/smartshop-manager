// File: UserEntity.kt
package com.premiumhub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val role: String, // "ADMIN" or "STAFF"
    val isApproved: Boolean = false,
    val shopId: Int? = null,
    val createdAt: Long = System.currentTimeMillis()
)