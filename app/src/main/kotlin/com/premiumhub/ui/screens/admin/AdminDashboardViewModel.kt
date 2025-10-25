package com.premiumhub.ui.screens.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class DashboardStats(
    val todaySales: Double = 0.0,
    val monthlySales: Double = 0.0,
    val totalStock: Int = 0,
    val staffCount: Int = 0,
    val pendingApprovals: Int = 0
)

sealed class DashboardState {
    object Loading : DashboardState()
    data class Success(val stats: DashboardStats) : DashboardState()
    data class Error(val message: String) : DashboardState()
}

class AdminDashboardViewModel : ViewModel() {
    private val _state = MutableStateFlow<DashboardState>(DashboardState.Loading)
    val state: StateFlow<DashboardState> = _state
    
    init {
        loadDashboardData()
    }
    
    private fun loadDashboardData() {
        viewModelScope.launch {
            try {
                // TODO: Load data from repository
                // Mock data for now
                val stats = DashboardStats(
                    todaySales = 235000.0,
                    monthlySales = 6500000.0,
                    totalStock = 1250,
                    staffCount = 12,
                    pendingApprovals = 2
                )
                _state.value = DashboardState.Success(stats)
            } catch (e: Exception) {
                _state.value = DashboardState.Error(e.message ?: "Failed to load data")
            }
        }
    }
    
    fun refresh() {
        loadDashboardData()
    }
}