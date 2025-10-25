// File: GetSalesUseCase.kt
package com.premiumhub.domain.usecase.sales

import com.premiumhub.data.local.entity.SalesEntity
import com.premiumhub.data.repository.SalesRepository
import kotlinx.coroutines.flow.Flow

class GetSalesUseCase(private val salesRepository: SalesRepository) {
    
    operator fun invoke(): Flow<List<SalesEntity>> {
        return salesRepository.getAllSales()
    }
}