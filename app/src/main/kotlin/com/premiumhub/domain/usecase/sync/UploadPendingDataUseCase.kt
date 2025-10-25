// File: UploadPendingDataUseCase.kt
package com.premiumhub.domain.usecase.sync

import com.premiumhub.data.repository.SyncRepository

class UploadPendingDataUseCase(private val syncRepository: SyncRepository) {
    
    suspend operator fun invoke() {
        syncRepository.uploadPendingData()
    }
}