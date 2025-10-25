package com.premiumhub.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class SignupState {
    object Initial : SignupState()
    object Loading : SignupState()
    data class Success(val message: String) : SignupState()
    data class Error(val message: String) : SignupState()
}

class SignupViewModel : ViewModel() {
    private val _state = MutableStateFlow<SignupState>(SignupState.Initial)
    val state: StateFlow<SignupState> = _state
    
    fun signup(name: String, email: String, password: String) {
        viewModelScope.launch {
            _state.value = SignupState.Loading
            
            try {
                // TODO: Implement signup logic with repository
                // For now, mock success
                kotlinx.coroutines.delay(1000) // Simulate network call
                _state.value = SignupState.Success("Signup request sent! Wait for admin approval.")
            } catch (e: Exception) {
                _state.value = SignupState.Error(e.message ?: "Signup failed")
            }
        }
    }
    
    fun resetState() {
        _state.value = SignupState.Initial
    }
}