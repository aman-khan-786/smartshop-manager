package com.premiumhub.ui.screens.sales.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.premiumhub.ui.components.DateRangePicker

@Composable
fun SalesFilterDialog(
    onDismiss: () -> Unit,
    onApply: (String, String, String) -> Unit
) {
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var selectedShop by remember { mutableStateOf("All Shops") }
    var expanded by remember { mutableStateOf(false) }
    
    val shops = listOf("All Shops", "Shop 1", "Shop 2", "Repair Center")
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Filter Sales") },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Date Range
                Text(
                    "Select Date Range",
                    style = MaterialTheme.typography.labelLarge
                )
                
                OutlinedTextField(
                    value = startDate,
                    onValueChange = { startDate = it },
                    label = { Text("Start Date") },
                    placeholder = { Text("DD/MM/YYYY") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                OutlinedTextField(
                    value = endDate,
                    onValueChange = { endDate = it },
                    label = { Text("End Date") },
                    placeholder = { Text("DD/MM/YYYY") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                // Shop Selection
                Text(
                    "Select Shop",
                    style = MaterialTheme.typography.labelLarge
                )
                
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = selectedShop,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Shop") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )
                    
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        shops.forEach { shop ->
                            DropdownMenuItem(
                                text = { Text(shop) },
                                onClick = {
                                    selectedShop = shop
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onApply(startDate, endDate, selectedShop)
                    onDismiss()
                }
            ) {
                Text("Apply Filter")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}