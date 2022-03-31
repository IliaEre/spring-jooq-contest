package com.epam.demo.jooqcontest.service

import com.epam.jooq.tables.records.ProductRecord
import com.epam.demo.jooqcontest.dto.ProductDto
import com.epam.demo.jooqcontest.repo.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun findAll(): List<ProductDto>? = productRepository.findAll()?.map { it.convert() }

    fun findOne(name: String): ProductDto? = productRepository.findOne(name)?.convert()

    fun findDescription(name: String): String? = productRepository.findDescription(name)

    @Transactional
    fun save(productDto: ProductDto) { productRepository.create(productDto) }

    fun ProductRecord.convert(): ProductDto =
        ProductDto(this.id, this.name, this.price, this.categoryId, this.vendor, null, null)

}
