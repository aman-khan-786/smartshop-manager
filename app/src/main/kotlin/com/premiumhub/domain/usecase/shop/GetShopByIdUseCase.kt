package com.premiumhub.domain.usecase.shop

import com.premiumhub.data.local.entity.ShopEntity
import com.premiumhub.data.repository.ShopRepository

class GetShopByIdUseCase(private val shopRepository: ShopRepository) {
    
    suspend operator fun invoke(shopId: Int): ShopEntity? {
        return shopRepository.getShopById(shopId)
    }
}