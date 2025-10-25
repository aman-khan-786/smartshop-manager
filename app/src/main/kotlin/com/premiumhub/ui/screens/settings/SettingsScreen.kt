package com.premiumhub.ui.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }
    var autoSyncEnabled by remember { mutableStateOf(true) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
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
            // App Settings Section
            Text(
                "App Settings",
                style = MaterialTheme.typography.titleLarge
            )
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.Notifications, null)
                        },
                        headlineContent = { Text("Notifications") },
                        supportingContent = { Text("Enable push notifications") },
                        trailingContent = {
                            Switch(
                                checked = notificationsEnabled,
                                onCheckedChange = { notificationsEnabled = it }
                            )
                        }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.DarkMode, null)
                        },
                        headlineContent = { Text("Dark Mode") },
                        supportingContent = { Text("Use dark theme") },
                        trailingContent = {
                            Switch(
                                checked = darkModeEnabled,
                                onCheckedChange = { darkModeEnabled = it }
                            )
                        }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.Sync, null)
                        },
                        headlineContent = { Text("Auto Sync") },
                        supportingContent = { Text("Automatically sync data") },
                        trailingContent = {
                            Switch(
                                checked = autoSyncEnabled,
                                onCheckedChange = { autoSyncEnabled = it }
                            )
                        }
                    )
                }
            }
            
            // Data Management Section
            Text(
                "Data Management",
                style = MaterialTheme.typography.titleLarge
            )
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.CloudSync, null)
                        },
                        headlineContent = { Text("Sync Now") },
                        supportingContent = { Text("Manually sync all data") },
                        trailingContent = {
                            Icon(Icons.Default.ChevronRight, null)
                        },
                        modifier = Modifier.clickable { /* TODO: Sync */ }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.Download, null)
                        },
                        headlineContent = { Text("Export Data") },
                        supportingContent = { Text("Download all your data") },
                        trailingContent = {
                            Icon(Icons.Default.ChevronRight, null)
                        },
                        modifier = Modifier.clickable { /* TODO: Export */ }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(
                                Icons.Default.DeleteSweep,
                                null,
                                tint = MaterialTheme.colorScheme.error
                            )
                        },
                        headlineContent = {
                            Text(
                                "Clear Cache",
                                color = MaterialTheme.colorScheme.error
                            )
                        },
                        supportingContent = { Text("Free up storage space") },
                        trailingContent = {
                            Icon(Icons.Default.ChevronRight, null)
                        },
                        modifier = Modifier.clickable { /* TODO: Clear cache */ }
                    )
                }
            }
            
            // About Section
            Text(
                "About",
                style = MaterialTheme.typography.titleLarge
            )
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.Info, null)
                        },
                        headlineContent = { Text("App Version") },
                        supportingContent = { Text("1.0.0 (Build 1)") }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.Policy, null)
                        },
                        headlineContent = { Text("Privacy Policy") },
                        trailingContent = {
                            Icon(Icons.Default.ChevronRight, null)
                        },
                        modifier = Modifier.clickable { /* TODO: Open privacy policy */ }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.Description, null)
                        },
                        headlineContent = { Text("Terms of Service") },
                        trailingContent = {
                            Icon(Icons.Default.ChevronRight, null)
                        },
                        modifier = Modifier.clickable { /* TODO: Open terms */ }
                    )
                    
                    Divider()
                    
                    ListItem(
                        leadingContent = {
                            Icon(Icons.Default.HelpOutline, null)
                        },
                        headlineContent = { Text("Help & Support") },
                        trailingContent = {
                            Icon(Icons.Default.ChevronRight, null)
                        },
                        modifier = Modifier.clickable { /* TODO: Open help */ }
                    )
                }
            }
        }
    }
}