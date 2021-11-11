package com.epam.contest.clientservice.service

import com.epam.jooq.tables.records.ProductRecord
import com.epam.contest.clientservice.dto.Product as OwnProduct
import com.epam.contest.clientservice.repo.UsefulRepository
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
    fun save(product: OwnProduct) = usefulRepository.create(product)

    fun convert(productRecord: ProductRecord): OwnProduct =
        OwnProduct(
            productRecord.id,
            productRecord.name,
            productRecord.price,
            productRecord.categoryId,
            productRecord.vendor,
            null,
            null
        )
}