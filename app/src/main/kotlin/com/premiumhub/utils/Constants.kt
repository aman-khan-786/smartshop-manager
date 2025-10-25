package com.premiumhub.utils

object Constants {
    // App Info
    const val APP_NAME = "SmartShop Manager"
    const val APP_VERSION = "1.0.0"
    
    // Database
    const val DATABASE_NAME = "smartshop_db"
    const val DATABASE_VERSION = 1
    
    // Preferences
    const val PREF_NAME = "smartshop_prefs"
    const val PREF_USER_ID = "user_id"
    const val PREF_USER_EMAIL = "user_email"
    const val PREF_USER_ROLE = "user_role"
    const val PREF_IS_LOGGED_IN = "is_logged_in"
    const val PREF_THEME_MODE = "theme_mode"
    
    // API Endpoints (if needed)
    const val BASE_URL = "https://api.premiumhub.com/"
    const val TIMEOUT_SECONDS = 30L
    
    // Validation
    const val MIN_PASSWORD_LENGTH = 6
    const val MAX_NAME_LENGTH = 50
    
    // Date Formats
    const val DATE_FORMAT = "dd/MM/yyyy"
    const val TIME_FORMAT = "hh:mm a"
    const val DATETIME_FORMAT = "dd/MM/yyyy hh:mm a"
    
    // Worker Tags
    const val SYNC_WORKER_TAG = "sync_worker"
    const val NOTIFICATION_WORKER_TAG = "notification_worker"
}