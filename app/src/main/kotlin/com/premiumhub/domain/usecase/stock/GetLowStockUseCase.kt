// File: GetLowStockUseCase.kt
package com.premiumhub.domain.usecase.stock

import com.premiumhub.data.local.entity.StockEntity
import com.premiumhub.data.repository.StockRepository
import kotlinx.coroutines.flow.Flow

class GetLowStockUseCase(private val stockRepository: StockRepository) {
    
    operator fun invoke(): Flow<List<StockEntity>> {
        return stockRepository.getLowStocks()
    }
}