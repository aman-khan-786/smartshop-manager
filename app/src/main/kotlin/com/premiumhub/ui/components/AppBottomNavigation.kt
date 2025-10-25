// File: AppBottomNavigation.kt
package com.premiumhub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun AppBottomNavigation(
    selectedRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Dashboard, contentDescription = null) },
            label = { Text("Dashboard") },
            selected = selectedRoute == "dashboard",
            onClick = { onNavigate("dashboard") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Inventory, contentDescription = null) },
            label = { Text("Stock") },
            selected = selectedRoute == "stock",
            onClick = { onNavigate("stock") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Assessment, contentDescription = null) },
            label = { Text("Sales") },
            selected = selectedRoute == "sales",
            onClick = { onNavigate("sales") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.CheckCircle, contentDescription = null) },
            label = { Text("Attendance") },
            selected = selectedRoute == "attendance",
            onClick = { onNavigate("attendance") }
        )
    }
}