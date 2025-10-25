package com.premiumhub.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SalesListItem(
    shopName: String,
    staffName: String,
    totalSales: String,
    date: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        ListItem(
            leadingContent = {
                Icon(Icons.Default.Store, null)
            },
            headlineContent = { Text(shopName) },
            supportingContent = {
                Column {
                    Text("By: $staffName")
                    Text("Date: $date")
                }
            },
            trailingContent = {
                Text(
                    totalSales,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        )
    }
}