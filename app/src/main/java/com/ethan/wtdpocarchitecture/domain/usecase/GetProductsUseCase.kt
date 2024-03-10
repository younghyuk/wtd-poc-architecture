package com.ethan.wtdpocarchitecture.domain.usecase

import com.ethan.wtdpocarchitecture.domain.ProductRepository
import com.ethan.wtdpocarchitecture.domain.model.Product

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {
    operator fun invoke() = productRepository.products
}