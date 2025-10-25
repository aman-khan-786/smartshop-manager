// File: User.kt
package com.premiumhub.domain.model

data class User(
    val id: Int = 0,
    val name: String,
    val email: String,
    val role: UserRole,
    val isApproved: Boolean = false,
    val shopId: Int? = null,
    val createdAt: Long = System.currentTimeMillis()
)