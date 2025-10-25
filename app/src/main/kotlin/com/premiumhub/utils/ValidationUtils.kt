package com.premiumhub.utils

import android.util.Patterns

object ValidationUtils {
    
    fun isValidEmail(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    fun isValidPassword(password: String): Boolean {
        return password.length >= Constants.MIN_PASSWORD_LENGTH
    }
    
    fun isValidName(name: String): Boolean {
        return name.isNotBlank() && name.length <= Constants.MAX_NAME_LENGTH
    }
    
    fun isValidPhone(phone: String): Boolean {
        return phone.isNotBlank() && phone.length == 10 && phone.all { it.isDigit() }
    }
    
    fun isValidAmount(amount: String): Boolean {
        return try {
            amount.toDouble() > 0
        } catch (e: Exception) {
            false
        }
    }
    
    fun getEmailError(email: String): String? {
        return when {
            email.isBlank() -> "Email is required"
            !isValidEmail(email) -> "Invalid email format"
            else -> null
        }
    }
    
    fun getPasswordError(password: String): String? {
        return when {
            password.isBlank() -> "Password is required"
            !isValidPassword(password) -> "Password must be at least ${Constants.MIN_PASSWORD_LENGTH} characters"
            else -> null
        }
    }
    
    fun getNameError(name: String): String? {
        return when {
            name.isBlank() -> "Name is required"
            !isValidName(name) -> "Name is too long"
            else -> null
        }
    }
}