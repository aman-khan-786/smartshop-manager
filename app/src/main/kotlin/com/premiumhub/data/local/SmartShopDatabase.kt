// File: SmartShopDatabase.kt
package com.premiumhub.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.premiumhub.data.local.dao.*
import com.premiumhub.data.local.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        UserEntity::class,
        ShopEntity::class,
        StockEntity::class,
        SalesEntity::class,
        AttendanceEntity::class,
        NotificationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SmartShopDatabase : RoomDatabase() {
    
    abstract fun userDao(): UserDao
    abstract fun shopDao(): ShopDao
    abstract fun stockDao(): StockDao
    abstract fun salesDao(): SalesDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun notificationDao(): NotificationDao
    
    companion object {
        @Volatile
        private var INSTANCE: SmartShopDatabase? = null
        
        fun getDatabase(context: Context): SmartShopDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SmartShopDatabase::class.java,
                    "smartshop_database"
                )
                    .addCallback(DatabaseCallback(context))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
        
        private class DatabaseCallback(
            private val context: Context
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        SampleDataSeeder.populateDatabase(
                            database.userDao(),
                            database.shopDao(),
                            database.stockDao(),
                            database.salesDao(),
                            database.attendanceDao()
                        )
                    }
                }
            }
        }
    }
}