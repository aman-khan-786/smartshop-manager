// File: UseCaseModule.kt
package com.premiumhub.di

import android.content.Context

// Simple factory for use cases
// When you need use cases, create them here
object UseCaseModule {
    
    // Auth Use Cases
    fun provideLoginUseCase(context: Context) = 
        RepositoryModule.provideUserRepository(context)
    
    fun provideSignupUseCase(context: Context) = 
        RepositoryModule.provideUserRepository(context)
    
    // Sales Use Cases
    fun provideAddSalesUseCase(context: Context) = 
        RepositoryModule.provideSalesRepository(context)
    
    fun provideGetSalesUseCase(context: Context) = 
        RepositoryModule.provideSalesRepository(context)
    
    // Stock Use Cases
    fun provideAddStockUseCase(context: Context) = 
        RepositoryModule.provideStockRepository(context)
    
    fun provideGetStockUseCase(context: Context) = 
        RepositoryModule.provideStockRepository(context)
    
    fun provideGetLowStockUseCase(context: Context) = 
        RepositoryModule.provideStockRepository(context)
    
    // Attendance Use Cases
    fun provideMarkAttendanceUseCase(context: Context) = 
        RepositoryModule.provideAttendanceRepository(context)
    
    fun provideGetAttendanceUseCase(context: Context) = 
        RepositoryModule.provideAttendanceRepository(context)
    
    // Shop Use Cases
    fun provideGetShopsUseCase(context: Context) = 
        RepositoryModule.provideShopRepository(context)
    
    // Notification Use Cases
    fun provideGetNotificationsUseCase(context: Context) = 
        RepositoryModule.provideNotificationRepository(context)
}