// File: AttendanceCard.kt
package com.premiumhub.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AttendanceCard(
    staffName: String,
    status: String,
    checkInTime: String?,
    date: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = staffName,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall
                )
                checkInTime?.let {
                    Text(
                        text = "Check-in: $it",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            FilterChip(
                selected = status == "PRESENT",
                onClick = {},
                label = { Text(status) }
            )
        }
    }
}