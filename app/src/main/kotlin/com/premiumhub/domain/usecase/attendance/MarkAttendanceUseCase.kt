// File: MarkAttendanceUseCase.kt
package com.premiumhub.domain.usecase.attendance

import com.premiumhub.data.local.entity.AttendanceEntity
import com.premiumhub.data.repository.AttendanceRepository

class MarkAttendanceUseCase(private val attendanceRepository: AttendanceRepository) {
    
    suspend operator fun invoke(attendance: AttendanceEntity): Long {
        return attendanceRepository.insertAttendance(attendance)
    }
}