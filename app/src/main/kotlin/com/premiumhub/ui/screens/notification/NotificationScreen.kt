package com.premiumhub.ui.screens.notification

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.components.NotificationItem

data class Notification(
    val id: Int,
    val title: String,
    val message: String,
    val time: String,
    val isRead: Boolean,
    val type: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    var notifications by remember {
        mutableStateOf(
            listOf(
                Notification(
                    1,
                    "New Signup Request",
                    "Neha Gupta requested to join Shop 1",
                    "5 minutes ago",
                    false,
                    "SIGNUP_REQUEST"
                ),
                Notification(
                    2,
                    "Low Stock Alert",
                    "iPhone 15 Pro stock is below 5 units",
                    "1 hour ago",
                    false,
                    "LOW_STOCK"
                ),
                Notification(
                    3,
                    "Sales Uploaded",
                    "Rahul Kumar uploaded today's sales",
                    "2 hours ago",
                    true,
                    "SALES_UPLOADED"
                ),
                Notification(
                    4,
                    "Attendance Marked",
                    "Today's attendance has been marked",
                    "3 hours ago",
                    true,
                    "GENERAL"
                )
            )
        )
    }
    
    val unreadCount = notifications.count { !it.isRead }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Notifications")
                        if (unreadCount > 0) {
                            Text(
                                "$unreadCount unread",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            notifications = notifications.map { it.copy(isRead = true) }
                        }
                    ) {
                        Icon(Icons.Default.DoneAll, "Mark all as read")
                    }
                }
            )
        }
    ) { padding ->
        if (notifications.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Column(
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.outline
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "No notifications",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(notifications) { notification ->
                    NotificationItem(
                        title = notification.title,
                        message = notification.message,
                        time = notification.time,
                        isRead = notification.isRead,
                        type = notification.type,
                        onClick = {
                            notifications = notifications.map {
                                if (it.id == notification.id) it.copy(isRead = true)
                                else it
                            }
                        }
                    )
                }
            }
        }
    }
}