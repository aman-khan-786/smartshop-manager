package com.premiumhub.utils

import java.text.DecimalFormat

object FormatUtils {
    
    fun formatCurrency(amount: Double): String {
        val formatter = DecimalFormat("#,##,###.00")
        return "₹${formatter.format(amount)}"
    }
    
    fun formatPercentage(value: Double): String {
        val formatter = DecimalFormat("##0.00")
        return "${formatter.format(value)}%"
    }
    
    fun formatNumber(number: Int): String {
        val formatter = DecimalFormat("#,###")
        return formatter.format(number)
    }
    
    fun parseDouble(value: String): Double {
        return try {
            value.replace(",", "").toDouble()
        } catch (e: Exception) {
            0.0
        }
    }
    
    fun parseInt(value: String): Int {
        return try {
            value.replace(",", "").toInt()
        } catch (e: Exception) {
            0
        }
    }
}