package com.epam.stock.jooqcontest.repo

import com.epam.jooq.Tables
import com.epam.jooq.tables.records.ProductRecord
import com.epam.stock.jooqcontest.dto.Product
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

@Repository
class UsefulRepository(
    private val dslContext: DSLContext
) {

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

    fun create(product: Product): Boolean =
        dslContext.transactionResult { ctx ->
            ctx.dsl()
                .insertInto(p, p.NAME, p.CATEGORY_ID, p.VENDOR, p.PRICE)
                .select(
                    DSL.select(
                        DSL.value(product.name),
                        DSL.value(product.categoryId),
                        DSL.value(product.vendor),
                        DSL.value(product.price)
                    )
                        .where(
                            DSL.notExists(
                                DSL.selectOne().from(p)
                                    .where(p.NAME.eq(product.name))
                            )
                        )
                )
                .execute() > 0
        }

    private companion object {
        val p = Tables.PRODUCT
        val d = Tables.DESCRIPTION
    }
}