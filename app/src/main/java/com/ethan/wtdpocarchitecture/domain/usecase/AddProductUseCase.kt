package com.ethan.wtdpocarchitecture.domain.usecase

import com.ethan.wtdpocarchitecture.domain.ProductRepository
import com.ethan.wtdpocarchitecture.domain.model.Product

class AddProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(product: Product) {
        productRepository.addProduct(product)
    }
}