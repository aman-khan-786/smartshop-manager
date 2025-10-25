// File: ShopDao.kt
package com.premiumhub.data.local.dao

// Yahan par explicit imports add kiye gaye hain
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.premiumhub.data.local.entity.ShopEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {

    @Query("SELECT * FROM shops")
    fun getAllShops(): Flow<List<ShopEntity>>

    @Query("SELECT * FROM shops WHERE id = :shopId")
    suspend fun getShopById(shopId: Int): ShopEntity?

    @Query("SELECT * FROM shops WHERE type = :type")
    fun getShopsByType(type: String): Flow<List<ShopEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShop(shop: ShopEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShops(shops: List<ShopEntity>)

    @Update
    suspend fun updateShop(shop: ShopEntity)

    @Delete
    suspend fun deleteShop(shop: ShopEntity)

    @Query("DELETE FROM shops")
    suspend fun deleteAllShops()
}
