// File: UpdateStockUseCase.kt
package com.premiumhub.domain.usecase.stock

import com.premiumhub.data.local.entity.StockEntity
import com.premiumhub.data.repository.StockRepository

class UpdateStockUseCase(private val stockRepository: StockRepository) {
    
    suspend operator fun invoke(stock: StockEntity) {
        stockRepository.updateStock(stock)
    }
}