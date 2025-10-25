package com.premiumhub.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(
        Constants.PREF_NAME,
        Context.MODE_PRIVATE
    )
    
    fun saveString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }
    
    fun getString(key: String, default: String = ""): String {
        return prefs.getString(key, default) ?: default
    }
    
    fun saveInt(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }
    
    fun getInt(key: String, default: Int = 0): Int {
        return prefs.getInt(key, default)
    }
    
    fun saveBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }
    
    fun getBoolean(key: String, default: Boolean = false): Boolean {
        return prefs.getBoolean(key, default)
    }
    
    fun clear() {
        prefs.edit().clear().apply()
    }
    
    // User Session
    fun saveUserSession(userId: Int, email: String, role: String) {
        saveInt(Constants.PREF_USER_ID, userId)
        saveString(Constants.PREF_USER_EMAIL, email)
        saveString(Constants.PREF_USER_ROLE, role)
        saveBoolean(Constants.PREF_IS_LOGGED_IN, true)
    }
    
    fun clearUserSession() {
        clear()
    }
    
    fun isLoggedIn(): Boolean {
        return getBoolean(Constants.PREF_IS_LOGGED_IN)
    }
}