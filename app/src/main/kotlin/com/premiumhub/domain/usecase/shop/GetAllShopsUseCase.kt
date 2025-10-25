// File: GetAllShopsUseCase.kt
package com.premiumhub.domain.usecase.shop

import com.premiumhub.data.local.entity.ShopEntity
import com.premiumhub.data.repository.ShopRepository
import kotlinx.coroutines.flow.Flow

class GetAllShopsUseCase(private val shopRepository: ShopRepository) {
    
    operator fun invoke(): Flow<List<ShopEntity>> {
        return shopRepository.getAllShops()
    }
}