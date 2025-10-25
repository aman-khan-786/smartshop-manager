// File: StockItemCard.kt
package com.premiumhub.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StockItemCard(
    itemName: String,
    quantity: Int,
    category: String,
    isLowStock: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = itemName,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = category,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            if (isLowStock) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Low Stock",
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Text(
                text = "Qty: $quantity",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}