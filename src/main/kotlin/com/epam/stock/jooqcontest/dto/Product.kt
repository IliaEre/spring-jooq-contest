package com.epam.stock.jooqcontest.dto

import java.math.BigDecimal

data class Product(
    val id: Int,
    val name: String?,
    val price: BigDecimal,
    val categoryId: Int?,
    val vendor: String?,
    val serialNumber: String?,
    val owner: String?
)