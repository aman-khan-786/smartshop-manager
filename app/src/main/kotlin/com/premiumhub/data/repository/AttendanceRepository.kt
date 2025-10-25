// File: AttendanceRepository.kt
package com.premiumhub.data.repository

import com.premiumhub.data.local.dao.AttendanceDao
import com.premiumhub.data.local.entity.AttendanceEntity
import kotlinx.coroutines.flow.Flow

class AttendanceRepository(private val attendanceDao: AttendanceDao) {
    
    fun getAllAttendance(): Flow<List<AttendanceEntity>> = attendanceDao.getAllAttendance()
    
    suspend fun getAttendanceById(attendanceId: Int): AttendanceEntity? = 
        attendanceDao.getAttendanceById(attendanceId)
    
    suspend fun getAttendanceByStaffAndDate(email: String, date: String): AttendanceEntity? = 
        attendanceDao.getAttendanceByStaffAndDate(email, date)
    
    fun getAttendanceByDate(date: String): Flow<List<AttendanceEntity>> = 
        attendanceDao.getAttendanceByDate(date)
    
    fun getAttendanceByStaff(email: String): Flow<List<AttendanceEntity>> = 
        attendanceDao.getAttendanceByStaff(email)
    
    fun getAttendanceByShopAndDate(shopId: Int, date: String): Flow<List<AttendanceEntity>> = 
        attendanceDao.getAttendanceByShopAndDate(shopId, date)
    
    fun getAttendanceByDateRange(startDate: String, endDate: String): Flow<List<AttendanceEntity>> = 
        attendanceDao.getAttendanceByDateRange(startDate, endDate)
    
    suspend fun insertAttendance(attendance: AttendanceEntity): Long = 
        attendanceDao.insertAttendance(attendance)
    
    suspend fun updateAttendance(attendance: AttendanceEntity) = 
        attendanceDao.updateAttendance(attendance)
    
    suspend fun deleteAttendance(attendance: AttendanceEntity) = 
        attendanceDao.deleteAttendance(attendance)
}