package com.ethan.wtdpocarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ethan.wtdpocarchitecture.DependenciesProvider
import com.ethan.wtdpocarchitecture.domain.ProductRepository
import com.ethan.wtdpocarchitecture.domain.model.Product
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val productRepository: ProductRepository = DependenciesProvider.productRepository
) : ViewModel() {
    val products = productRepository.products.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )
    fun loadProductAll() {
        viewModelScope.launch {
            productRepository.loadProductAll()
        }
    }
    fun addProduct(product: Product) {
        viewModelScope.launch {
            productRepository.addProduct(product)
        }
    }
    fun removeLastProduct() {
        viewModelScope.launch {
            productRepository.removeLastProduct()
        }
    }
}