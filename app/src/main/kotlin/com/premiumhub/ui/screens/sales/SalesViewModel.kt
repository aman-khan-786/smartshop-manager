package com.premiumhub.ui.screens.sales

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class SalesData(
    val id: Int,
    val shopName: String,
    val staffName: String,
    val totalSales: Double,
    val date: String
)

class SalesViewModel : ViewModel() {
    private val _salesList = MutableStateFlow<List<SalesData>>(emptyList())
    val salesList: StateFlow<List<SalesData>> = _salesList
    
    fun loadSales() {
        // TODO: Load from repository
    }
    
    fun filterSales(startDate: String, endDate: String, shop: String) {
        // TODO: Filter logic
    }
}