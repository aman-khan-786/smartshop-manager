// File: GetAllNotificationsUseCase.kt
package com.premiumhub.domain.usecase.notification

import com.premiumhub.data.local.entity.NotificationEntity
import com.premiumhub.data.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotificationsUseCase(private val notificationRepository: NotificationRepository) {
    
    operator fun invoke(): Flow<List<NotificationEntity>> {
        return notificationRepository.getAllNotifications()
    }
}