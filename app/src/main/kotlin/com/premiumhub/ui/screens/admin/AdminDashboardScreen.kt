package com.premiumhub.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.components.StatsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Admin Dashboard") },
                actions = {
                    IconButton(onClick = { navController.navigate("notifications") }) {
                        Icon(Icons.Default.Notifications, "Notifications")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    "Dashboard Overview",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            
            // Stats Cards
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatsCard(
                        title = "Today's Sales",
                        value = "₹2,35,000",
                        icon = Icons.Default.TrendingUp,
                        modifier = Modifier.weight(1f)
                    )
                    StatsCard(
                        title = "Monthly Sales",
                        value = "₹65,00,000",
                        icon = Icons.Default.Assessment,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatsCard(
                        title = "Total Stock",
                        value = "1,250",
                        icon = Icons.Default.Inventory,
                        modifier = Modifier.weight(1f)
                    )
                    StatsCard(
                        title = "Staff Count",
                        value = "12",
                        icon = Icons.Default.People,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            
            // Quick Actions
            item {
                Text(
                    "Quick Actions",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
            item {
                Card(
                    onClick = { navController.navigate("manage_staff") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.People, null) },
                        headlineContent = { Text("Manage Staff") },
                        supportingContent = { Text("View and manage staff members") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) }
                    )
                }
            }
            
            item {
                Card(
                    onClick = { navController.navigate("staff_approval") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Approval, null) },
                        headlineContent = { Text("Pending Approvals") },
                        supportingContent = { Text("2 staff requests pending") },
                        trailingContent = {
                            Badge { Text("2") }
                        }
                    )
                }
            }
            
            item {
                Card(
                    onClick = { navController.navigate("stock_management") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Inventory, null) },
                        headlineContent = { Text("Stock Management") },
                        supportingContent = { Text("Manage inventory") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) }
                    )
                }
            }
            
            item {
                Card(
                    onClick = { navController.navigate("view_reports") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Assessment, null) },
                        headlineContent = { Text("View Reports") },
                        supportingContent = { Text("Sales and performance reports") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) }
                    )
                }
            }
        }
    }
}