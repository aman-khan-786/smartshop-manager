// File: SearchStockUseCase.kt
package com.premiumhub.domain.usecase.stock

import com.premiumhub.data.local.entity.StockEntity
import com.premiumhub.data.repository.StockRepository
import kotlinx.coroutines.flow.Flow

class SearchStockUseCase(private val stockRepository: StockRepository) {
    
    operator fun invoke(query: String): Flow<List<StockEntity>> {
        return stockRepository.searchStocks(query)
    }
}