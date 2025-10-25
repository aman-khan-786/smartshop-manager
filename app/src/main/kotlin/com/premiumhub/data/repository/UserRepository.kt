// File: UserRepository.kt
package com.premiumhub.data.repository

import com.premiumhub.data.local.dao.UserDao
import com.premiumhub.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    
    fun getAllUsers(): Flow<List<UserEntity>> = userDao.getAllUsers()
    
    suspend fun getUserById(userId: Int): UserEntity? = userDao.getUserById(userId)
    
    suspend fun getUserByEmail(email: String): UserEntity? = userDao.getUserByEmail(email)
    
    suspend fun login(email: String, password: String): UserEntity? = 
        userDao.login(email, password)
    
    fun getPendingUsers(): Flow<List<UserEntity>> = userDao.getPendingUsers()
    
    fun getStaffByShop(shopId: Int): Flow<List<UserEntity>> = userDao.getStaffByShop(shopId)
    
    suspend fun approveUser(userId: Int, isApproved: Boolean) = 
        userDao.updateApprovalStatus(userId, isApproved)
    
    suspend fun insertUser(user: UserEntity): Long = userDao.insertUser(user)
    
    suspend fun updateUser(user: UserEntity) = userDao.updateUser(user)
    
    suspend fun deleteUser(user: UserEntity) = userDao.deleteUser(user)
}