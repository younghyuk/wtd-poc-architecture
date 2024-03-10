package com.ethan.wtdpocarchitecture.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column {
        Column {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "load product")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "add new product")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "remove first product")
            }
        }
        LazyColumn {
            items(PRODUCTS_SAMPLE) {
                Text(text = it.name)
            }
        }
    }
}

data class Product(val id: String, val name: String, val price: Int)

val PRODUCTS_SAMPLE = listOf(
    Product("p1", "product-1", 1),
    Product("p2", "product-2", 2),
    Product("p3", "product-3", 3),
    Product("p4", "product-4", 4),
    Product("p5", "product-5", 5),
)