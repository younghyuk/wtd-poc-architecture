package com.ethan.wtdpocarchitecture

import com.ethan.wtdpocarchitecture.data.InMemoryProductDataSource
import com.ethan.wtdpocarchitecture.data.ProductDataSource
import com.ethan.wtdpocarchitecture.data.ProductRepositoryImpl
import com.ethan.wtdpocarchitecture.domain.ProductRepository

object DependenciesProvider {
    val productDataSource: ProductDataSource = InMemoryProductDataSource()
    val productRepository: ProductRepository = ProductRepositoryImpl(productDataSource)
}