package com.premiumhub.ui.screens.staff

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.components.CustomButton
import com.premiumhub.ui.screens.staff.components.SalesFormCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadSalesScreen(navController: NavController) {
    var totalSales by remember { mutableStateOf("") }
    var cashSales by remember { mutableStateOf("") }
    var onlineSales by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Upload Sales") },
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Today's Date", style = MaterialTheme.typography.labelMedium)
                    Text("25 October 2025", style = MaterialTheme.typography.titleMedium)
                }
            }
            
            SalesFormCard(
                totalSales = totalSales,
                cashSales = cashSales,
                onlineSales = onlineSales,
                notes = notes,
                onTotalChange = { totalSales = it },
                onCashChange = { cashSales = it },
                onOnlineChange = { onlineSales = it },
                onNotesChange = { notes = it }
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            CustomButton(
                text = "Submit Sales",
                onClick = {
                    // TODO: Upload sales
                    navController.navigateUp()
                }
            )
        }
    }
}