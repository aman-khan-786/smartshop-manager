package com.premiumhub.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class UserProfile(
    val name: String = "",
    val email: String = "",
    val role: String = "",
    val profileImage: String? = null
)

sealed class ProfileState {
    object Loading : ProfileState()
    data class Success(val profile: UserProfile) : ProfileState()
    data class Error(val message: String) : ProfileState()
}

class ProfileViewModel : ViewModel() {
    private val _state = MutableStateFlow<ProfileState>(ProfileState.Loading)
    val state: StateFlow<ProfileState> = _state
    
    init {
        loadProfile()
    }
    
    private fun loadProfile() {
        viewModelScope.launch {
            try {
                // TODO: Load from repository
                val profile = UserProfile(
                    name = "Admin User",
                    email = "admin@premiumhub.com",
                    role = "ADMIN"
                )
                _state.value = ProfileState.Success(profile)
            } catch (e: Exception) {
                _state.value = ProfileState.Error(e.message ?: "Failed to load profile")
            }
        }
    }
    
    fun updateProfile(name: String, email: String) {
        viewModelScope.launch {
            // TODO: Update profile in repository
        }
    }
    
    fun logout() {
        viewModelScope.launch {
            // TODO: Clear user session
        }
    }
}