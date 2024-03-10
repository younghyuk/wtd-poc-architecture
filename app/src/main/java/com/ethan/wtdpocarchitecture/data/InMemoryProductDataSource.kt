package com.ethan.wtdpocarchitecture.data

import com.ethan.wtdpocarchitecture.data.model.PRODUCTS_SAMPLE
import com.ethan.wtdpocarchitecture.data.model.ProductModel
import com.ethan.wtdpocarchitecture.data.model.toDataModel
import com.ethan.wtdpocarchitecture.data.model.toDomainModel
import com.ethan.wtdpocarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class InMemoryProductDataSource : ProductDataSource {
    private val _products = MutableStateFlow(emptyList<ProductModel>())
    override val products: Flow<List<Product>> = _products.map { productList ->
        productList.map { it.toDomainModel() }
    }
    override suspend fun loadProductAll() {
        _products.update { PRODUCTS_SAMPLE }
    }
    override suspend fun addProduct(product: Product) {
        _products.getAndUpdate { it + product.toDataModel() }
    }
    override suspend fun removeLastProduct() {
        _products.getAndUpdate { it.dropLast(1) }
    }
}