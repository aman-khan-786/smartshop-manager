package com.premiumhub.ui.screens.sales

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
import com.premiumhub.ui.components.SalesListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesListScreen(navController: NavController) {
    val salesList = remember {
        listOf(
            Triple("Shop 1", "Rahul Kumar", "₹35,000"),
            Triple("Shop 2", "Priya Sharma", "₹42,500"),
            Triple("Repair Center", "Amit Singh", "₹18,000")
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sales Records") },
                actions = {
                    IconButton(onClick = { /* Filter */ }) {
                        Icon(Icons.Default.FilterList, "Filter")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("upload_sales") }) {
                Icon(Icons.Default.Add, "Add Sales")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(salesList) { (shop, staff, amount) ->
                SalesListItem(
                    shopName = shop,
                    staffName = staff,
                    totalSales = amount,
                    date = "25 Oct 2025",
                    onClick = { navController.navigate("sales_detail/1") }
                )
            }
        }
    }
}