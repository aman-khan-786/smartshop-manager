// File: CreateNotificationUseCase.kt
package com.premiumhub.domain.usecase.notification

import com.premiumhub.data.local.entity.NotificationEntity
import com.premiumhub.data.repository.NotificationRepository

class CreateNotificationUseCase(private val notificationRepository: NotificationRepository) {
    
    suspend operator fun invoke(notification: NotificationEntity): Long {
        return notificationRepository.insertNotification(notification)
    }
}