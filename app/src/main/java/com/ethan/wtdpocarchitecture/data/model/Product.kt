package com.ethan.wtdpocarchitecture.data.model

import kotlin.random.Random

data class Product(val id: String, val name: String, val price: Int)

fun product(): Product = Product(
    id = "p${Random.nextInt()}",
    name = "product-${Random.nextInt()}",
    price = Random.nextInt()
)

val PRODUCTS_SAMPLE = listOf(
    Product("p1", "product-1", 1),
    Product("p2", "product-2", 2),
    Product("p3", "product-3", 3),
    Product("p4", "product-4", 4),
    Product("p5", "product-5", 5),
)
