package com.premiumhub.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Permission(
    val name: String,
    val description: String,
    var isGranted: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermissionManagementScreen(navController: NavController) {
    var permissions by remember {
        mutableStateOf(
            listOf(
                Permission("Manage Stock", "Add, edit, delete stock items", false),
                Permission("View Reports", "Access sales and performance reports", true),
                Permission("Manage Staff", "Add or remove staff members", false),
                Permission("Upload Sales", "Upload daily sales data", true),
                Permission("Mark Attendance", "Record staff attendance", true),
                Permission("Export Data", "Export reports to PDF/CSV", false)
            )
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Permission Management") },
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
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Staff Permissions",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        "Manage what staff members can do",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(permissions) { permission ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    permission.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    permission.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Switch(
                                checked = permission.isGranted,
                                onCheckedChange = { checked ->
                                    permissions = permissions.map {
                                        if (it.name == permission.name) {
                                            it.copy(isGranted = checked)
                                        } else it
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}