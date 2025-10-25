// File: AttendanceEntity.kt
package com.premiumhub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance")
data class AttendanceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val staffName: String,
    val staffEmail: String,
    val shopId: Int,
    val date: String, // Format: "yyyy-MM-dd"
    val status: String, // "PRESENT", "ABSENT", "LEAVE"
    val checkInTime: String? = null,
    val checkOutTime: String? = null,
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)