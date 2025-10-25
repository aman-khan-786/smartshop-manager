// File: DeleteSalesUseCase.kt
package com.premiumhub.domain.usecase.sales

import com.premiumhub.data.local.entity.SalesEntity
import com.premiumhub.data.repository.SalesRepository

class DeleteSalesUseCase(private val salesRepository: SalesRepository) {
    
    suspend operator fun invoke(sale: SalesEntity) {
        salesRepository.deleteSale(sale)
    }
}