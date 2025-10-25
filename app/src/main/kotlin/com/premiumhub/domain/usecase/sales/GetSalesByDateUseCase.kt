// File: GetSalesByDateUseCase.kt
package com.premiumhub.domain.usecase.sales

import com.premiumhub.data.local.entity.SalesEntity
import com.premiumhub.data.repository.SalesRepository
import kotlinx.coroutines.flow.Flow

class GetSalesByDateUseCase(private val salesRepository: SalesRepository) {
    
    operator fun invoke(date: String): Flow<List<SalesEntity>> {
        return salesRepository.getSalesByDate(date)
    }
}