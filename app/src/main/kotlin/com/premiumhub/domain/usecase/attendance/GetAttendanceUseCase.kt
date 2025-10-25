// File: GetAttendanceUseCase.kt
package com.premiumhub.domain.usecase.attendance

import com.premiumhub.data.local.entity.AttendanceEntity
import com.premiumhub.data.repository.AttendanceRepository
import kotlinx.coroutines.flow.Flow

class GetAttendanceUseCase(private val attendanceRepository: AttendanceRepository) {
    
    operator fun invoke(): Flow<List<AttendanceEntity>> {
        return attendanceRepository.getAllAttendance()
    }
}