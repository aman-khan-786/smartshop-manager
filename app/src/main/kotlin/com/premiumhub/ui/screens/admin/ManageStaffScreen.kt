package com.premiumhub.ui.screens.admin

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

data class StaffMember(
    val id: Int,
    val name: String,
    val email: String,
    val shopName: String,
    val isApproved: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageStaffScreen(navController: NavController) {
    // Mock data
    val staffList = remember {
        listOf(
            StaffMember(1, "Rahul Kumar", "rahul@premiumhub.com", "Shop 1", true),
            StaffMember(2, "Priya Sharma", "priya@premiumhub.com", "Shop 2", true),
            StaffMember(3, "Amit Singh", "amit@premiumhub.com", "Repair Center", true)
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Manage Staff") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(staffList) { staff ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ListItem(
                        headlineContent = { Text(staff.name) },
                        supportingContent = {
                            Column {
                                Text(staff.email)
                                Text("Shop: ${staff.shopName}")
                            }
                        },
                        leadingContent = {
                            Icon(Icons.Default.Person, null)
                        },
                        trailingContent = {
                            IconButton(onClick = { /* TODO: Delete staff */ }) {
                                Icon(Icons.Default.Delete, "Delete")
                            }
                        }
                    )
                }
            }
        }
    }
}