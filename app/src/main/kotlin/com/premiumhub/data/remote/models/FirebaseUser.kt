// File: FirebaseUser.kt
package com.premiumhub.data.remote.models

// Firebase compatible user model
data class FirebaseUser(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = "",
    val isApproved: Boolean = false,
    val shopId: String? = null,
    val createdAt: Long = 0
)