// File: FirebaseAttendance.kt
package com.premiumhub.data.remote.models

data class FirebaseAttendance(
    val id: String = "",
    val staffName: String = "",
    val staffEmail: String = "",
    val shopId: String = "",
    val date: String = "",
    val status: String = "",
    val checkInTime: String? = null,
    val checkOutTime: String? = null,
    val createdAt: Long = 0
)