// File: LoginUseCase.kt
package com.premiumhub.domain.usecase.auth

import com.premiumhub.data.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    
    suspend operator fun invoke(email: String, password: String) = 
        userRepository.login(email, password)
}