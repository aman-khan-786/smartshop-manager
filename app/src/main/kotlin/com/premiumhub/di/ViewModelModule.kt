// File: ViewModelModule.kt
package com.premiumhub.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Simple ViewModel Factory
class ViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // ViewModels will be created using this factory
        // Repositories will be injected here
        
        @Suppress("UNCHECKED_CAST")
        return when {
            // Add your ViewModels here when created
            // Example:
            // modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
            //     LoginViewModel(
            //         RepositoryModule.provideUserRepository(context)
            //     ) as T
            // }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
    
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        
        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ViewModelFactory(context.applicationContext).also {
                    instance = it
                }
            }
        }
    }
}