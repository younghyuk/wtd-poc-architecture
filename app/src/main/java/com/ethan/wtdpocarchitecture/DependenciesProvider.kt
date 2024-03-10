package com.ethan.wtdpocarchitecture

import com.ethan.wtdpocarchitecture.data.InMemoryProductDataSource
import com.ethan.wtdpocarchitecture.data.ProductDataSource
import com.ethan.wtdpocarchitecture.data.ProductRepositoryImpl
import com.ethan.wtdpocarchitecture.domain.ProductRepository
import com.ethan.wtdpocarchitecture.domain.usecase.AddProductUseCase
import com.ethan.wtdpocarchitecture.domain.usecase.GetProductsUseCase
import com.ethan.wtdpocarchitecture.domain.usecase.LoadProductAllUseCase
import com.ethan.wtdpocarchitecture.domain.usecase.RemoveLastProductUseCase

object DependenciesProvider {
    val productDataSource: ProductDataSource = InMemoryProductDataSource()
    val productRepository: ProductRepository = ProductRepositoryImpl(productDataSource)
    val getProductsUseCase: GetProductsUseCase = GetProductsUseCase(productRepository)
    val loadProductAllUseCase: LoadProductAllUseCase = LoadProductAllUseCase(productRepository)
    val addProductUseCase: AddProductUseCase = AddProductUseCase(productRepository)
    val removeLastProductUseCase: RemoveLastProductUseCase = RemoveLastProductUseCase(productRepository)
}