// File: StockRepository.kt
package com.premiumhub.data.repository

import com.premiumhub.data.local.dao.StockDao
import com.premiumhub.data.local.entity.StockEntity
import kotlinx.coroutines.flow.Flow

class StockRepository(private val stockDao: StockDao) {
    
    fun getAllStocks(): Flow<List<StockEntity>> = stockDao.getAllStocks()
    
    suspend fun getStockById(stockId: Int): StockEntity? = stockDao.getStockById(stockId)
    
    fun getStocksByShop(shopId: Int): Flow<List<StockEntity>> = 
        stockDao.getStocksByShop(shopId)
    
    fun getLowStocks(): Flow<List<StockEntity>> = stockDao.getLowStocks()
    
    fun getStocksByCategory(category: String): Flow<List<StockEntity>> = 
        stockDao.getStocksByCategory(category)
    
    fun searchStocks(query: String): Flow<List<StockEntity>> = 
        stockDao.searchStocks(query)
    
    suspend fun insertStock(stock: StockEntity): Long = stockDao.insertStock(stock)
    
    suspend fun updateStock(stock: StockEntity) = stockDao.updateStock(stock)
    
    suspend fun deleteStock(stock: StockEntity) = stockDao.deleteStock(stock)
}