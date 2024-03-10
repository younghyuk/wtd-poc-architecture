package com.ethan.wtdpocarchitecture.data

import com.ethan.wtdpocarchitecture.domain.ProductRepository
import com.ethan.wtdpocarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(private val productDataSource: ProductDataSource) : ProductRepository {
    override val products: Flow<List<Product>> = productDataSource.products
    override suspend fun loadProductAll() {
        productDataSource.loadProductAll()
    }
    override suspend fun addProduct(product: Product) {
        productDataSource.addProduct(product)
    }
    override suspend fun removeLastProduct() {
        productDataSource.removeLastProduct()
    }
}