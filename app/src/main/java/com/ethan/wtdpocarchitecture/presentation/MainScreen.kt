package com.ethan.wtdpocarchitecture.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ethan.wtdpocarchitecture.data.model.product

@Composable
fun MainScreen() {
    val viewModel = viewModel<MainViewModel>()
    val products by viewModel.products.collectAsStateWithLifecycle()

    Column {
        Column {
            Button(onClick = { viewModel.loadProductAll() }) {
                Text(text = "load product")
            }
            Button(onClick = { viewModel.addProduct(product()) }) {
                Text(text = "add new product")
            }
            Button(onClick = { viewModel.removeLastProduct() }) {
                Text(text = "remove first product")
            }
        }
        LazyColumn {
            items(products) {
                Text(text = it.name)
            }
        }
    }
}