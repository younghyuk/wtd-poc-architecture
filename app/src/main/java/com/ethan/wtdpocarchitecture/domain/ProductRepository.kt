package com.ethan.wtdpocarchitecture.domain

import com.ethan.wtdpocarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    val products: Flow<List<Product>>
    suspend fun loadProductAll()
    suspend fun addProduct(product: Product)
    suspend fun removeLastProduct()
}