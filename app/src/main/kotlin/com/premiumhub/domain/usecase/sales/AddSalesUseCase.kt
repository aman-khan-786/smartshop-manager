// File: AddSalesUseCase.kt
package com.premiumhub.domain.usecase.sales

import com.premiumhub.data.local.entity.SalesEntity
import com.premiumhub.data.repository.SalesRepository

class AddSalesUseCase(private val salesRepository: SalesRepository) {
    
    suspend operator fun invoke(sale: SalesEntity): Long {
        return salesRepository.insertSale(sale)
    }
}