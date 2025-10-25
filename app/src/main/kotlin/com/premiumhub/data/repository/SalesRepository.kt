// File: SalesRepository.kt
package com.premiumhub.data.repository

import com.premiumhub.data.local.dao.SalesDao
import com.premiumhub.data.local.entity.SalesEntity
import kotlinx.coroutines.flow.Flow

class SalesRepository(private val salesDao: SalesDao) {
    
    fun getAllSales(): Flow<List<SalesEntity>> = salesDao.getAllSales()
    
    suspend fun getSaleById(saleId: Int): SalesEntity? = salesDao.getSaleById(saleId)
    
    fun getSalesByShop(shopId: Int): Flow<List<SalesEntity>> = 
        salesDao.getSalesByShop(shopId)
    
    fun getSalesByDate(date: String): Flow<List<SalesEntity>> = 
        salesDao.getSalesByDate(date)
    
    fun getSalesByDateRange(startDate: String, endDate: String): Flow<List<SalesEntity>> = 
        salesDao.getSalesByDateRange(startDate, endDate)
    
    fun getSalesByStaff(email: String): Flow<List<SalesEntity>> = 
        salesDao.getSalesByStaff(email)
    
    suspend fun getTotalSalesForDate(date: String): Double = 
        salesDao.getTotalSalesForDate(date) ?: 0.0
    
    suspend fun getTotalSalesForRange(startDate: String, endDate: String): Double = 
        salesDao.getTotalSalesForRange(startDate, endDate) ?: 0.0
    
    suspend fun insertSale(sale: SalesEntity): Long = salesDao.insertSale(sale)
    
    suspend fun updateSale(sale: SalesEntity) = salesDao.updateSale(sale)
    
    suspend fun deleteSale(sale: SalesEntity) = salesDao.deleteSale(sale)
}