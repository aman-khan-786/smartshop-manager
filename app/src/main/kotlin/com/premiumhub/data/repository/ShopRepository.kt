// File: ShopRepository.kt
package com.premiumhub.data.repository

import com.premiumhub.data.local.dao.ShopDao
import com.premiumhub.data.local.entity.ShopEntity
import kotlinx.coroutines.flow.Flow

class ShopRepository(private val shopDao: ShopDao) {
    
    fun getAllShops(): Flow<List<ShopEntity>> = shopDao.getAllShops()
    
    suspend fun getShopById(shopId: Int): ShopEntity? = shopDao.getShopById(shopId)
    
    fun getShopsByType(type: String): Flow<List<ShopEntity>> = shopDao.getShopsByType(type)
    
    suspend fun insertShop(shop: ShopEntity): Long = shopDao.insertShop(shop)
    
    suspend fun updateShop(shop: ShopEntity) = shopDao.updateShop(shop)
    
    suspend fun deleteShop(shop: ShopEntity) = shopDao.deleteShop(shop)
}