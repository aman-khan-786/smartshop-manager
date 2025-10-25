// File: GetAttendanceByStaffUseCase.kt
package com.premiumhub.domain.usecase.attendance

import com.premiumhub.data.local.entity.AttendanceEntity
import com.premiumhub.data.repository.AttendanceRepository
import kotlinx.coroutines.flow.Flow

class GetAttendanceByStaffUseCase(private val attendanceRepository: AttendanceRepository) {
    
    operator fun invoke(email: String): Flow<List<AttendanceEntity>> {
        return attendanceRepository.getAttendanceByStaff(email)
    }
}