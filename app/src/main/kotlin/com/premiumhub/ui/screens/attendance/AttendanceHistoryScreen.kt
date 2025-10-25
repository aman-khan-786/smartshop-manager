package com.premiumhub.ui.screens.attendance

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.components.AttendanceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(navController: NavController) {
    val attendanceHistory = remember {
        listOf(
            Triple("Rahul Kumar", "PRESENT", "2025-10-20"),
            Triple("Priya Sharma", "PRESENT", "2025-10-20"),
            Triple("Amit Singh", "LEAVE", "2025-10-20"),
            Triple("Rahul Kumar", "PRESENT", "2025-10-19"),
            Triple("Priya Sharma", "ABSENT", "2025-10-19")
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Attendance History") },
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
            items(attendanceHistory) { (name, status, date) ->
                AttendanceCard(
                    staffName = name,
                    status = status,
                    checkInTime = if (status == "PRESENT") "09:00 AM" else null,
                    date = date
                )
            }
        }
    }
}