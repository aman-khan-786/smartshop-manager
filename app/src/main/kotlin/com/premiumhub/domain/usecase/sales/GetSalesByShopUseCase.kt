// File: GetSalesByShopUseCase.kt
package com.premiumhub.domain.usecase.sales

import com.premiumhub.data.local.entity.SalesEntity
import com.premiumhub.data.repository.SalesRepository
import kotlinx.coroutines.flow.Flow

class GetSalesByShopUseCase(private val salesRepository: SalesRepository) {
    
    operator fun invoke(shopId: Int): Flow<List<SalesEntity>> {
        return salesRepository.getSalesByShop(shopId)
    }
}