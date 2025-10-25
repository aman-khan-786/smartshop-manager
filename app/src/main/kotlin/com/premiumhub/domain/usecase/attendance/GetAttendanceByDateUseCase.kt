// File: GetAttendanceByDateUseCase.kt
package com.premiumhub.domain.usecase.attendance

import com.premiumhub.data.local.entity.AttendanceEntity
import com.premiumhub.data.repository.AttendanceRepository
import kotlinx.coroutines.flow.Flow

class GetAttendanceByDateUseCase(private val attendanceRepository: AttendanceRepository) {
    
    operator fun invoke(date: String): Flow<List<AttendanceEntity>> {
        return attendanceRepository.getAttendanceByDate(date)
    }
}