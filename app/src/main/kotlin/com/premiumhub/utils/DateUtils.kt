package com.premiumhub.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return sdf.format(Date())
    }
    
    fun getCurrentTime(): String {
        val sdf = SimpleDateFormat(Constants.TIME_FORMAT, Locale.getDefault())
        return sdf.format(Date())
    }
    
    fun getCurrentDateTime(): String {
        val sdf = SimpleDateFormat(Constants.DATETIME_FORMAT, Locale.getDefault())
        return sdf.format(Date())
    }
    
    fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
    
    fun formatTime(timestamp: Long): String {
        val sdf = SimpleDateFormat(Constants.TIME_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
    
    fun formatDateTime(timestamp: Long): String {
        val sdf = SimpleDateFormat(Constants.DATETIME_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
    
    fun getTimestamp(): Long = System.currentTimeMillis()
}