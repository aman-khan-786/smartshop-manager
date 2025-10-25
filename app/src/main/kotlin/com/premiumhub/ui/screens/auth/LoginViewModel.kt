// File: LoginViewModel.kt
package com.premiumhub.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class LoginState {
    object Initial : LoginState()
    object Loading : LoginState()
    data class Success(val role: String) : LoginState()
    data class Error(val message: String) : LoginState()
}

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow<LoginState>(LoginState.Initial)
    val state: StateFlow<LoginState> = _state
    
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _state.value = LoginState.Loading
            // TODO: Implement login logic
            // For now, mock success
            _state.value = LoginState.Success("ADMIN")
        }
    }
}