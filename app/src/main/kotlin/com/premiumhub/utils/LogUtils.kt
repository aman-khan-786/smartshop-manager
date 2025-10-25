package com.premiumhub.utils

import android.util.Log

object LogUtils {
    private const val TAG = "SmartShop"
    private const val DEBUG = true
    
    fun d(message: String, tag: String = TAG) {
        if (DEBUG) Log.d(tag, message)
    }
    
    fun i(message: String, tag: String = TAG) {
        if (DEBUG) Log.i(tag, message)
    }
    
    fun w(message: String, tag: String = TAG) {
        if (DEBUG) Log.w(tag, message)
    }
    
    fun e(message: String, throwable: Throwable? = null, tag: String = TAG) {
        if (DEBUG) {
            if (throwable != null) {
                Log.e(tag, message, throwable)
            } else {
                Log.e(tag, message)
            }
        }
    }
}