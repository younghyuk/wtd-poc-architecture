package com.ethan.wtdpocarchitecture.domain.usecase

import com.ethan.wtdpocarchitecture.domain.ProductRepository

class LoadProductAllUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() {
        productRepository.loadProductAll()
    }
}