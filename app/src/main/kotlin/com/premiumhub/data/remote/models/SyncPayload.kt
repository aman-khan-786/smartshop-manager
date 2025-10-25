// File: SyncPayload.kt
package com.premiumhub.data.remote.models

// For syncing offline data to Firebase
data class SyncPayload(
    val userId: String,
    val users: List<FirebaseUser> = emptyList(),
    val sales: List<FirebaseSales> = emptyList(),
    val stocks: List<FirebaseStock> = emptyList(),
    val attendance: List<FirebaseAttendance> = emptyList(),
    val timestamp: Long = System.currentTimeMillis()
)