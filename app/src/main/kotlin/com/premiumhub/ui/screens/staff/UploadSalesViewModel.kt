package com.premiumhub.ui.screens.staff

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UploadState {
    object Initial : UploadState()
    object Loading : UploadState()
    data class Success(val message: String) : UploadState()
    data class Error(val message: String) : UploadState()
}

class UploadSalesViewModel : ViewModel() {
    private val _state = MutableStateFlow<UploadState>(UploadState.Initial)
    val state: StateFlow<UploadState> = _state
    
    fun uploadSales(
        totalSales: Double,
        cashSales: Double,
        onlineSales: Double,
        notes: String
    ) {
        viewModelScope.launch {
            _state.value = UploadState.Loading
            try {
                // TODO: Upload to repository
                _state.value = UploadState.Success("Sales uploaded successfully")
            } catch (e: Exception) {
                _state.value = UploadState.Error(e.message ?: "Upload failed")
            }
        }
    }
}