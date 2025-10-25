// File: AttendanceDao.kt
package com.premiumhub.data.local.dao

// Yahan par explicit imports add kiye gaye hain
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.premiumhub.data.local.entity.AttendanceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AttendanceDao {

    @Query("SELECT * FROM attendance ORDER BY createdAt DESC")
    fun getAllAttendance(): Flow<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance WHERE id = :attendanceId")
    suspend fun getAttendanceById(attendanceId: Int): AttendanceEntity?

    @Query("SELECT * FROM attendance WHERE staffEmail = :email AND date = :date LIMIT 1")
    suspend fun getAttendanceByStaffAndDate(email: String, date: String): AttendanceEntity?

    @Query("SELECT * FROM attendance WHERE date = :date")
    fun getAttendanceByDate(date: String): Flow<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance WHERE staffEmail = :email ORDER BY createdAt DESC")
    fun getAttendanceByStaff(email: String): Flow<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance WHERE shopId = :shopId AND date = :date")
    fun getAttendanceByShopAndDate(shopId: Int, date: String): Flow<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance WHERE date BETWEEN :startDate AND :endDate")
    fun getAttendanceByDateRange(startDate: String, endDate: String): Flow<List<AttendanceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(attendance: AttendanceEntity): Long

    @Update
    suspend fun updateAttendance(attendance: AttendanceEntity)

    @Delete
    suspend fun deleteAttendance(attendance: AttendanceEntity)

    @Query("DELETE FROM attendance")
    suspend fun deleteAllAttendance()
}
