// File: RepositoryModule.kt
package com.premiumhub.di

import android.content.Context
import com.premiumhub.data.repository.*

object RepositoryModule {
    
    fun provideUserRepository(context: Context): UserRepository {
        return UserRepository(DatabaseModule.provideUserDao(context))
    }
    
    fun provideShopRepository(context: Context): ShopRepository {
        return ShopRepository(DatabaseModule.provideShopDao(context))
    }
    
    fun provideStockRepository(context: Context): StockRepository {
        return StockRepository(DatabaseModule.provideStockDao(context))
    }
    
    fun provideSalesRepository(context: Context): SalesRepository {
        return SalesRepository(DatabaseModule.provideSalesDao(context))
    }
    
    fun provideAttendanceRepository(context: Context): AttendanceRepository {
        return AttendanceRepository(DatabaseModule.provideAttendanceDao(context))
    }
    
    fun provideNotificationRepository(context: Context): NotificationRepository {
        return NotificationRepository(DatabaseModule.provideNotificationDao(context))
    }
    
    fun provideSyncRepository(): SyncRepository {
        return SyncRepository()
    }
}