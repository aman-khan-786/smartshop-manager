// File: StockDao.kt
package com.premiumhub.data.local.dao

// Yahan par explicit imports add kiye gaye hain
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.premiumhub.data.local.entity.StockEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {

    @Query("SELECT * FROM stocks ORDER BY lastUpdated DESC")
    fun getAllStocks(): Flow<List<StockEntity>>

    @Query("SELECT * FROM stocks WHERE id = :stockId")
    suspend fun getStockById(stockId: Int): StockEntity?

    @Query("SELECT * FROM stocks WHERE shopId = :shopId ORDER BY lastUpdated DESC")
    fun getStocksByShop(shopId: Int): Flow<List<StockEntity>>

    @Query("SELECT * FROM stocks WHERE quantity < minStockLevel")
    fun getLowStocks(): Flow<List<StockEntity>>

    @Query("SELECT * FROM stocks WHERE category = :category")
    fun getStocksByCategory(category: String): Flow<List<StockEntity>>

    @Query("SELECT * FROM stocks WHERE itemName LIKE '%' || :query || '%'")
    fun searchStocks(query: String): Flow<List<StockEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStock(stock: StockEntity): Long

    @Update
    suspend fun updateStock(stock: StockEntity)

    @Delete
    suspend fun deleteStock(stock: StockEntity)

    @Query("DELETE FROM stocks")
    suspend fun deleteAllStocks()
}
