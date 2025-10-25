package com.premiumhub.ui.screens.staff

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class StaffStats(
    val todaySales: Double = 0.0,
    val monthlySales: Double = 0.0
)

class StaffDashboardViewModel : ViewModel() {
    private val _stats = MutableStateFlow(StaffStats())
    val stats: StateFlow<StaffStats> = _stats
    
    fun loadStats() {
        // TODO: Load from repository
    }
}