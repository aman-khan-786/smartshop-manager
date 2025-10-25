package com.premiumhub.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AttendanceStatusChip(
    status: String,
    modifier: Modifier = Modifier
) {
    val (containerColor, contentColor) = when (status) {
        "PRESENT" -> MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.primary
        "ABSENT" -> MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.error
        "LEAVE" -> MaterialTheme.colorScheme.tertiaryContainer to MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.surfaceVariant to MaterialTheme.colorScheme.onSurfaceVariant
    }
    
    AssistChip(
        onClick = {},
        label = { Text(status) },
        modifier = modifier,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = containerColor,
            labelColor = contentColor
        )
    )
}