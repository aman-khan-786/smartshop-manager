// File: SalesChart.kt
package com.premiumhub.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SalesChart(
    data: List<Float>,
    modifier: Modifier = Modifier
) {
    val color = MaterialTheme.colorScheme.primary
    
    Column(modifier = modifier) {
        Text(
            "Sales Overview",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Canvas(modifier = Modifier.fillMaxWidth().height(200.dp)) {
            val width = size.width
            val height = size.height
            val maxValue = data.maxOrNull() ?: 1f
            val itemWidth = width / data.size
            
            data.forEachIndexed { index, value ->
                val barHeight = (value / maxValue) * height
                drawRect(
                    color = color,
                    topLeft = Offset(index * itemWidth, height - barHeight),
                    size = androidx.compose.ui.geometry.Size(itemWidth * 0.8f, barHeight)
                )
            }
        }
    }
}