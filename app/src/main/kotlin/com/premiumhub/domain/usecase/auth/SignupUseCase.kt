// File: SignupUseCase.kt
package com.premiumhub.domain.usecase.auth

import com.premiumhub.data.local.entity.UserEntity
import com.premiumhub.data.repository.UserRepository

class SignupUseCase(private val userRepository: UserRepository) {
    
    suspend operator fun invoke(user: UserEntity): Long {
        return userRepository.insertUser(user)
    }
}