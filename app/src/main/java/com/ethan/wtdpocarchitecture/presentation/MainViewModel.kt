package com.ethan.wtdpocarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ethan.wtdpocarchitecture.DependenciesProvider
import com.ethan.wtdpocarchitecture.domain.model.Product
import com.ethan.wtdpocarchitecture.domain.usecase.AddProductUseCase
import com.ethan.wtdpocarchitecture.domain.usecase.GetProductsUseCase
import com.ethan.wtdpocarchitecture.domain.usecase.LoadProductAllUseCase
import com.ethan.wtdpocarchitecture.domain.usecase.RemoveLastProductUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val getProductsUseCase: GetProductsUseCase = DependenciesProvider.getProductsUseCase,
    private val loadProductAllUseCase: LoadProductAllUseCase = DependenciesProvider.loadProductAllUseCase,
    private val addProductUseCase: AddProductUseCase = DependenciesProvider.addProductUseCase,
    private val removeLastProductUseCase: RemoveLastProductUseCase = DependenciesProvider.removeLastProductUseCase,
) : ViewModel() {
    val products = getProductsUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )
    fun loadProductAll() {
        viewModelScope.launch { loadProductAllUseCase() }
    }
    fun addProduct(product: Product) {
        viewModelScope.launch { addProductUseCase(product) }
    }
    fun removeLastProduct() {
        viewModelScope.launch { removeLastProductUseCase() }
    }
}