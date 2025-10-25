// File: DatabaseModule.kt
package com.premiumhub.di

import android.content.Context
import com.premiumhub.data.local.SmartShopDatabase

object DatabaseModule {
    
    @Volatile
    private var database: SmartShopDatabase? = null
    
    fun provideDatabase(context: Context): SmartShopDatabase {
        return database ?: synchronized(this) {
            val instance = SmartShopDatabase.getDatabase(context)
            database = instance
            instance
        }
    }
    
    fun provideUserDao(context: Context) = provideDatabase(context).userDao()
    
    fun provideShopDao(context: Context) = provideDatabase(context).shopDao()
    
    fun provideStockDao(context: Context) = provideDatabase(context).stockDao()
    
    fun provideSalesDao(context: Context) = provideDatabase(context).salesDao()
    
    fun provideAttendanceDao(context: Context) = provideDatabase(context).attendanceDao()
    
    fun provideNotificationDao(context: Context) = provideDatabase(context).notificationDao()
}