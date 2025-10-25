// File: MarkNotificationReadUseCase.kt
package com.premiumhub.domain.usecase.notification

import com.premiumhub.data.repository.NotificationRepository

class MarkNotificationReadUseCase(private val notificationRepository: NotificationRepository) {
    
    suspend operator fun invoke(notificationId: Int) {
        notificationRepository.markAsRead(notificationId)
    }
}