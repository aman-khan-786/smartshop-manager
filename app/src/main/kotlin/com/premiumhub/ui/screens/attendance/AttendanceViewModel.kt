package com.premiumhub.ui.screens.attendance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class AttendanceRecord(
    val staffId: Int,
    val status: String,
    val date: String
)

sealed class AttendanceState {
    object Initial : AttendanceState()
    object Loading : AttendanceState()
    data class Success(val message: String) : AttendanceState()
    data class Error(val message: String) : AttendanceState()
}

class AttendanceViewModel : ViewModel() {
    private val _state = MutableStateFlow<AttendanceState>(AttendanceState.Initial)
    val state: StateFlow<AttendanceState> = _state
    
    fun submitAttendance(records: List<AttendanceRecord>) {
        viewModelScope.launch {
            _state.value = AttendanceState.Loading
            try {
                // TODO: Save to repository
                _state.value = AttendanceState.Success("Attendance marked successfully")
            } catch (e: Exception) {
                _state.value = AttendanceState.Error(e.message ?: "Failed to mark attendance")
            }
        }
    }
}