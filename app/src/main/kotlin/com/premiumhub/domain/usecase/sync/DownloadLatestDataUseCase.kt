// File: DownloadLatestDataUseCase.kt
package com.premiumhub.domain.usecase.sync

import com.premiumhub.data.repository.SyncRepository

class DownloadLatestDataUseCase(private val syncRepository: SyncRepository) {
    
    suspend operator fun invoke() {
        syncRepository.downloadLatestData()
    }
}