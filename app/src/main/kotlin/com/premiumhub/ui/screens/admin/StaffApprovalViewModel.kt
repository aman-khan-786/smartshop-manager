package com.premiumhub.ui.screens.admin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StaffApprovalViewModel : ViewModel() {
    private val _pendingStaff = MutableStateFlow<List<StaffMember>>(emptyList())
    val pendingStaff: StateFlow<List<StaffMember>> = _pendingStaff
    
    fun approveStaff(staffId: Int) {
        // TODO: Approve staff
    }
    
    fun rejectStaff(staffId: Int) {
        // TODO: Reject staff
    }
}