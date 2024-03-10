package com.ethan.wtdpocarchitecture

import com.ethan.wtdpocarchitecture.data.ProductRepositoryImpl
import com.ethan.wtdpocarchitecture.domain.ProductRepository

object DependenciesProvider {
    val productRepository: ProductRepository = ProductRepositoryImpl()
}