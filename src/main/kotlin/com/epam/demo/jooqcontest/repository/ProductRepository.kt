package com.epam.demo.jooqcontest.repository

import com.epam.jooq.Tables
import com.epam.jooq.tables.records.ProductRecord
import com.epam.demo.jooqcontest.dto.ProductDto
import com.epam.jooq.tables.Description
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(private val dslContext: DSLContext) {

    fun findAll(): MutableList<ProductRecord>? =
        dslContext
            .select(p.fields().toList())
            .from(p)
            .fetchInto(ProductRecord::class.java)

    fun findOne(name: String): ProductRecord? =
        dslContext
            .select(p.fields().toList())
            .from(p)
            .where(p.NAME.eq(name))
            .limit(1)
            .fetchOneInto(ProductRecord::class.java)

    fun findDescription(name: String): String? =
        dslContext
            .select(d.DESCR)
            .from(d)
            .join(p).on(p.ID.eq(d.PRODUCT_ID))
            .where(p.NAME.eq(name))
            .limit(1)
            .fetchOneInto(String::class.java)

    fun create(productDto: ProductDto): Boolean =
        dslContext.transactionResult { ctx ->
            ctx.dsl()
                .insertInto(p, p.NAME, p.CATEGORY_ID, p.VENDOR, p.PRICE)
                .select(
                    DSL.select(
                        DSL.value(productDto.name),
                        DSL.value(productDto.categoryId),
                        DSL.value(productDto.vendor),
                        DSL.value(productDto.price)
                    )
                        .where(
                            DSL.notExists(
                                DSL.selectOne().from(p)
                                    .where(p.NAME.eq(productDto.name))
                            )
                        )
                )
                .execute() > 0
        }

    private companion object {
        val p: com.epam.jooq.tables.Product = Tables.PRODUCT
        val d: Description = Tables.DESCRIPTION
    }

}
