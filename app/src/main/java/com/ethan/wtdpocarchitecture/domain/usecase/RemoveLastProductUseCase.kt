package com.ethan.wtdpocarchitecture.domain.usecase

import com.ethan.wtdpocarchitecture.domain.ProductRepository

class RemoveLastProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() {
        productRepository.removeLastProduct()
    }
}