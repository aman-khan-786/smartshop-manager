// File: Attendance.kt
package com.premiumhub.domain.model

data class Attendance(
    val id: Int = 0,
    val staffName: String,
    val staffEmail: String,
    val shopId: Int,
    val date: String,
    val status: AttendanceStatus,
    val checkInTime: String? = null,
    val checkOutTime: String? = null,
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)