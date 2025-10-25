package com.premiumhub.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    var showLogoutDialog by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile Header
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(16.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        "Admin User",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        "admin@premiumhub.com",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    AssistChip(
                        onClick = {},
                        label = { Text("ADMIN") },
                        leadingIcon = {
                            Icon(Icons.Default.AdminPanelSettings, null)
                        }
                    )
                }
            }
            
            // Account Settings
            Text(
                "Account Settings",
                style = MaterialTheme.typography.titleMedium
            )
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Edit, null) },
                        headlineContent = { Text("Edit Profile") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) },
                        modifier = Modifier.clickable { /* TODO */ }
                    )
                    Divider()
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Lock, null) },
                        headlineContent = { Text("Change Password") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) },
                        modifier = Modifier.clickable { /* TODO */ }
                    )
                }
            }
            
            // App Settings
            Text(
                "App Settings",
                style = MaterialTheme.typography.titleMedium
            )
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Notifications, null) },
                        headlineContent = { Text("Notifications") },
                        trailingContent = {
                            Switch(
                                checked = true,
                                onCheckedChange = {}
                            )
                        }
                    )
                    Divider()
                    ListItem(
                        leadingContent = { Icon(Icons.Default.DarkMode, null) },
                        headlineContent = { Text("Dark Mode") },
                        trailingContent = {
                            Switch(
                                checked = false,
                                onCheckedChange = {}
                            )
                        }
                    )
                }
            }
            
            // About
            Text(
                "About",
                style = MaterialTheme.typography.titleMedium
            )
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Info, null) },
                        headlineContent = { Text("App Version") },
                        supportingContent = { Text("1.0.0") }
                    )
                    Divider()
                    ListItem(
                        leadingContent = { Icon(Icons.Default.HelpOutline, null) },
                        headlineContent = { Text("Help & Support") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) },
                        modifier = Modifier.clickable { /* TODO */ }
                    )
                }
            }
            
            // Logout Button
            Button(
                onClick = { showLogoutDialog = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Icon(Icons.Default.Logout, null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Logout")
            }
        }
    }
    
    // Logout Confirmation Dialog
    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Logout") },
            text = { Text("Are you sure you want to logout?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        navController.navigate("login") {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                ) {
                    Text("Logout")
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}