package com.epam.stock.jooqcontest.service

import com.epam.jooq.tables.records.ProductRecord
import com.epam.stock.jooqcontest.dto.Product
import com.epam.stock.jooqcontest.repo.UsefulRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsefulService(
    private val usefulRepository: UsefulRepository
) {

    fun findAll() = usefulRepository.findAll()?.map { convert(it) }

    fun findOne(name: String) = usefulRepository.findOne(name)?.let { convert(it) }

    fun findOneWithDescr(name: String) = usefulRepository.findDescription(name)

    @Transactional
    fun save(product: Product) = usefulRepository.create(product)

    fun convert(productRecord: ProductRecord): Product =
        Product(
            productRecord.id,
            productRecord.name,
            productRecord.price,
            productRecord.categoryId,
            productRecord.vendor,
            null,
            null
        )
}