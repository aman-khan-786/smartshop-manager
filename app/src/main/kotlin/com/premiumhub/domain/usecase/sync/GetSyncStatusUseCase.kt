// File: GetSyncStatusUseCase.kt
package com.premiumhub.domain.usecase.sync

import com.premiumhub.data.repository.SyncRepository

class GetSyncStatusUseCase(private val syncRepository: SyncRepository) {
    
    suspend operator fun invoke(): Boolean {
        return syncRepository.getSyncStatus()
    }
}