package com.premiumhub.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.components.SalesChart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewReportsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reports") },
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
                    Text("Monthly Sales", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(8.dp))
                    SalesChart(
                        data = listOf(50000f, 65000f, 55000f, 70000f, 80000f, 90000f, 100000f)
                    )
                }
            }
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Summary", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Total Revenue:")
                        Text("₹65,00,000", style = MaterialTheme.typography.titleMedium)
                    }
                    Divider(Modifier.padding(vertical = 8.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Total Sales:")
                        Text("₹2,35,000", style = MaterialTheme.typography.titleMedium)
                    }
                    Divider(Modifier.padding(vertical = 8.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Total Items Sold:")
                        Text("1,250", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
            
            Button(
                onClick = { /* TODO: Export report */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Export Report")
            }
        }
    }
}