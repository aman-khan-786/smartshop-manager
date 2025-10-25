package com.premiumhub.domain.usecase.shop

import com.premiumhub.data.local.entity.ShopEntity
import com.premiumhub.data.repository.ShopRepository

class AddShopUseCase(private val shopRepository: ShopRepository) {
    
    suspend operator fun invoke(shop: ShopEntity): Long {
        return shopRepository.insertShop(shop)
    }
}