package com.ethan.wtdpocarchitecture.presentation

import androidx.lifecycle.ViewModel
import com.ethan.wtdpocarchitecture.data.model.PRODUCTS_SAMPLE
import com.ethan.wtdpocarchitecture.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _products = MutableStateFlow(emptyList<Product>())
    val products = _products.asStateFlow()
    fun loadProductAll() {
        _products.update { PRODUCTS_SAMPLE }
    }
    fun addProduct(product: Product) {
        _products.getAndUpdate { it + product }
    }
    fun removeLastProduct() {
        _products.getAndUpdate { it.dropLast(1) }
    }
}