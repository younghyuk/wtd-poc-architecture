package com.ethan.wtdpocarchitecture.data

import com.ethan.wtdpocarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    val products: Flow<List<Product>>
    suspend fun loadProductAll()
    suspend fun addProduct(product: Product)
    suspend fun removeLastProduct()
}