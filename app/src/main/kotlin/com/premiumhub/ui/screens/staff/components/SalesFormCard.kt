package com.premiumhub.ui.screens.staff.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.premiumhub.ui.components.CustomTextField

@Composable
fun SalesFormCard(
    totalSales: String,
    cashSales: String,
    onlineSales: String,
    notes: String,
    onTotalChange: (String) -> Unit,
    onCashChange: (String) -> Unit,
    onOnlineChange: (String) -> Unit,
    onNotesChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                "Enter Sales Details",
                style = MaterialTheme.typography.titleMedium
            )
            
            CustomTextField(
                value = totalSales,
                onValueChange = onTotalChange,
                label = "Total Sales Amount"
            )
            
            CustomTextField(
                value = cashSales,
                onValueChange = onCashChange,
                label = "Cash Sales"
            )
            
            CustomTextField(
                value = onlineSales,
                onValueChange = onOnlineChange,
                label = "Online Sales"
            )
            
            OutlinedTextField(
                value = notes,
                onValueChange = onNotesChange,
                label = { Text("Notes (Optional)") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )
        }
    }
}