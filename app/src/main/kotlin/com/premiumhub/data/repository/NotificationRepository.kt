// File: NotificationRepository.kt
package com.premiumhub.data.repository

import com.premiumhub.data.local.dao.NotificationDao
import com.premiumhub.data.local.entity.NotificationEntity
import kotlinx.coroutines.flow.Flow

class NotificationRepository(private val notificationDao: NotificationDao) {
    
    fun getAllNotifications(): Flow<List<NotificationEntity>> = 
        notificationDao.getAllNotifications()
    
    fun getUnreadNotifications(): Flow<List<NotificationEntity>> = 
        notificationDao.getUnreadNotifications()
    
    suspend fun getNotificationById(notificationId: Int): NotificationEntity? = 
        notificationDao.getNotificationById(notificationId)
    
    fun getNotificationsByUser(userId: Int): Flow<List<NotificationEntity>> = 
        notificationDao.getNotificationsByUser(userId)
    
    fun getUnreadCount(): Flow<Int> = notificationDao.getUnreadCount()
    
    suspend fun markAsRead(notificationId: Int) = 
        notificationDao.markAsRead(notificationId)
    
    suspend fun markAllAsRead() = notificationDao.markAllAsRead()
    
    suspend fun insertNotification(notification: NotificationEntity): Long = 
        notificationDao.insertNotification(notification)
    
    suspend fun deleteNotification(notification: NotificationEntity) = 
        notificationDao.deleteNotification(notification)
}