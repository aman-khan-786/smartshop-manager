package com.premiumhub.ui.screens.admin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ReportData(
    val monthlySales: List<Float> = emptyList(),
    val totalRevenue: Double = 0.0,
    val totalSales: Double = 0.0,
    val itemsSold: Int = 0
)

class ViewReportsViewModel : ViewModel() {
    private val _reportData = MutableStateFlow(ReportData())
    val reportData: StateFlow<ReportData> = _reportData
    
    fun loadReports() {
        // TODO: Load from repository
    }
    
    fun exportReport() {
        // TODO: Export to PDF/CSV
    }
}