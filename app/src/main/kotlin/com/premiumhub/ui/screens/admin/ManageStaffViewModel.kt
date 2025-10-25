package com.premiumhub.ui.screens.admin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ManageStaffViewModel : ViewModel() {
    private val _staffList = MutableStateFlow<List<StaffMember>>(emptyList())
    val staffList: StateFlow<List<StaffMember>> = _staffList
    
    init {
        loadStaff()
    }
    
    private fun loadStaff() {
        // TODO: Load from repository
    }
    
    fun deleteStaff(staffId: Int) {
        // TODO: Delete staff
    }
}