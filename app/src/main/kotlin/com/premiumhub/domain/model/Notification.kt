// File: Notification.kt
package com.premiumhub.domain.model

data class Notification(
    val id: Int = 0,
    val title: String,
    val message: String,
    val type: NotificationType,
    val isRead: Boolean = false,
    val targetUserId: Int? = null,
    val relatedId: Int? = null,
    val createdAt: Long = System.currentTimeMillis()
)

enum class NotificationType {
    SIGNUP_REQUEST,
    LOW_STOCK,
    SALES_UPLOADED,
    GENERAL
}