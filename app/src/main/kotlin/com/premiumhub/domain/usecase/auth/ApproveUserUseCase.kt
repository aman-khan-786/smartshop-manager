// File: ApproveUserUseCase.kt
package com.premiumhub.domain.usecase.auth

import com.premiumhub.data.repository.UserRepository

class ApproveUserUseCase(private val userRepository: UserRepository) {
    
    suspend operator fun invoke(userId: Int, isApproved: Boolean) {
        userRepository.approveUser(userId, isApproved)
    }
}