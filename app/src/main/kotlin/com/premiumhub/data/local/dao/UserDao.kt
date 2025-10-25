// File: UserDao.kt
package com.premiumhub.data.local.dao

import androidx.room.*
import com.premiumhub.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>
    
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Int): UserEntity?
    
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): UserEntity?
    
    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun login(email: String, password: String): UserEntity?
    
    @Query("SELECT * FROM users WHERE isApproved = 0")
    fun getPendingUsers(): Flow<List<UserEntity>>
    
    @Query("SELECT * FROM users WHERE role = 'STAFF' AND shopId = :shopId")
    fun getStaffByShop(shopId: Int): Flow<List<UserEntity>>
    
    @Query("UPDATE users SET isApproved = :isApproved WHERE id = :userId")
    suspend fun updateApprovalStatus(userId: Int, isApproved: Boolean)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity): Long
    
    @Update
    suspend fun updateUser(user: UserEntity)
    
    @Delete
    suspend fun deleteUser(user: UserEntity)
    
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()
}