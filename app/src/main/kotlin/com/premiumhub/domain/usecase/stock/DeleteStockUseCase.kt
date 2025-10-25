// File: DeleteStockUseCase.kt
package com.premiumhub.domain.usecase.stock

import com.premiumhub.data.local.entity.StockEntity
import com.premiumhub.data.repository.StockRepository

class DeleteStockUseCase(private val stockRepository: StockRepository) {
    
    suspend operator fun invoke(stock: StockEntity) {
        stockRepository.deleteStock(stock)
    }
}