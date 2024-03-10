package com.ethan.wtdpocarchitecture.domain.model

import kotlin.random.Random

data class Product(val id: String, val name: String, val price: Int)

fun product(): Product = Product(
    id = "p${Random.nextInt()}",
    name = "product-${Random.nextInt()}",
    price = Random.nextInt()
)
