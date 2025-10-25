package com.premiumhub.ui.screens.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class NotificationData(
    val notifications: List<Notification> = emptyList(),
    val unreadCount: Int = 0
)

sealed class NotificationState {
    object Loading : NotificationState()
    data class Success(val data: NotificationData) : NotificationState()
    data class Error(val message: String) : NotificationState()
}

class NotificationViewModel : ViewModel() {
    private val _state = MutableStateFlow<NotificationState>(NotificationState.Loading)
    val state: StateFlow<NotificationState> = _state
    
    init {
        loadNotifications()
    }
    
    private fun loadNotifications() {
        viewModelScope.launch {
            try {
                // TODO: Load from repository
                val notifications = listOf<Notification>()
                _state.value = NotificationState.Success(
                    NotificationData(
                        notifications = notifications,
                        unreadCount = notifications.count { !it.isRead }
                    )
                )
            } catch (e: Exception) {
                _state.value = NotificationState.Error(e.message ?: "Failed to load notifications")
            }
        }
    }
    
    fun markAsRead(notificationId: Int) {
        viewModelScope.launch {
            // TODO: Mark as read in repository
        }
    }
    
    fun markAllAsRead() {
        viewModelScope.launch {
            // TODO: Mark all as read in repository
        }
    }
}