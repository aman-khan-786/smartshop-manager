package com.premiumhub.ui.screens.attendance

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
import com.premiumhub.ui.components.CustomButton

data class StaffAttendance(
    val id: Int,
    val name: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavController) {
    var staffList by remember {
        mutableStateOf(
            listOf(
                StaffAttendance(1, "Rahul Kumar", "NOT_MARKED"),
                StaffAttendance(2, "Priya Sharma", "NOT_MARKED"),
                StaffAttendance(3, "Amit Singh", "NOT_MARKED")
            )
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mark Attendance") },
                actions = {
                    IconButton(onClick = { navController.navigate("attendance_history") }) {
                        Icon(Icons.Default.History, "History")
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
                        "Today's Date",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        "25 October 2025",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(staffList) { staff ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(staff.name, style = MaterialTheme.typography.titleMedium)
                                Text(
                                    "Status: ${staff.status}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                FilledTonalButton(
                                    onClick = {
                                        staffList = staffList.map {
                                            if (it.id == staff.id) it.copy(status = "PRESENT")
                                            else it
                                        }
                                    }
                                ) {
                                    Text("Present")
                                }
                                OutlinedButton(
                                    onClick = {
                                        staffList = staffList.map {
                                            if (it.id == staff.id) it.copy(status = "ABSENT")
                                            else it
                                        }
                                    }
                                ) {
                                    Text("Absent")
                                }
                            }
                        }
                    }
                }
            }
            
            CustomButton(
                text = "Submit Attendance",
                onClick = { /* TODO: Submit */ },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}