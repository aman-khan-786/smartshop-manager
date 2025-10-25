// File: FirebaseStock.kt
package com.premiumhub.data.remote.models

data class FirebaseStock(
    val id: String = "",
    val itemName: String = "",
    val quantity: Int = 0,
    val category: String = "",
    val shopId: String = "",
    val addedBy: String = "",
    val dateAdded: Long = 0,
    val lastUpdated: Long = 0
)