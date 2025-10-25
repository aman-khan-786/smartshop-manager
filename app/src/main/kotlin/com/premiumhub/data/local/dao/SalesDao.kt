// File: SalesDao.kt
package com.premiumhub.data.local.dao

// Yahan par explicit imports add kiye gaye hain
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.premiumhub.data.local.entity.SalesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SalesDao {

    @Query("SELECT * FROM sales ORDER BY createdAt DESC")
    fun getAllSales(): Flow<List<SalesEntity>>

    @Query("SELECT * FROM sales WHERE id = :saleId")
    suspend fun getSaleById(saleId: Int): SalesEntity?

    @Query("SELECT * FROM sales WHERE shopId = :shopId ORDER BY createdAt DESC")
    fun getSalesByShop(shopId: Int): Flow<List<SalesEntity>>

    @Query("SELECT * FROM sales WHERE date = :date ORDER BY createdAt DESC")
    fun getSalesByDate(date: String): Flow<List<SalesEntity>>

    @Query("SELECT * FROM sales WHERE date BETWEEN :startDate AND :endDate ORDER BY createdAt DESC")
    fun getSalesByDateRange(startDate: String, endDate: String): Flow<List<SalesEntity>>

    @Query("SELECT * FROM sales WHERE staffEmail = :email ORDER BY createdAt DESC")
    fun getSalesByStaff(email: String): Flow<List<SalesEntity>>

    @Query("SELECT SUM(totalSales) FROM sales WHERE date = :date")
    suspend fun getTotalSalesForDate(date: String): Double?

    @Query("SELECT SUM(totalSales) FROM sales WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalSalesForRange(startDate: String, endDate: String): Double?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSale(sale: SalesEntity): Long

    @Update
    suspend fun updateSale(sale: SalesEntity)

    @Delete
    suspend fun deleteSale(sale: SalesEntity)

    @Query("DELETE FROM sales")
    suspend fun deleteAllSales()
}
