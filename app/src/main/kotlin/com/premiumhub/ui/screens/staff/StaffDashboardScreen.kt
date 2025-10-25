package com.premiumhub.ui.screens.staff

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.screens.staff.components.QuickStatsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffDashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Staff Dashboard") },
                actions = {
                    IconButton(onClick = { navController.navigate("notifications") }) {
                        Icon(Icons.Default.Notifications, "Notifications")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("upload_sales") }
            ) {
                Icon(Icons.Default.Upload, "Upload Sales")
            }
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
                    "Welcome Back!",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    "Here's your quick overview",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    QuickStatsCard(
                        title = "Today's Sales",
                        value = "₹15,000",
                        icon = Icons.Default.TrendingUp,
                        modifier = Modifier.weight(1f)
                    )
                    QuickStatsCard(
                        title = "This Month",
                        value = "₹3,50,000",
                        icon = Icons.Default.Assessment,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            
            item {
                Text(
                    "Quick Actions",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
            item {
                Card(
                    onClick = { navController.navigate("upload_sales") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Upload, null) },
                        headlineContent = { Text("Upload Today's Sales") },
                        supportingContent = { Text("Record your daily sales") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) }
                    )
                }
            }
            
            item {
                Card(
                    onClick = { navController.navigate("attendance") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.CheckCircle, null) },
                        headlineContent = { Text("Mark Attendance") },
                        supportingContent = { Text("Check in for today") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) }
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
                        headlineContent = { Text("View Stock") },
                        supportingContent = { Text("Check available inventory") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) }
                    )
                }
            }
        }
    }
}