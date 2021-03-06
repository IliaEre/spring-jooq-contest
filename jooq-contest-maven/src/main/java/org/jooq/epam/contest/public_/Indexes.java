/*
 * This file is generated by jOOQ.
 */
package org.jooq.epam.contest.public_;


import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.epam.contest.public_.tables.Product;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index VENDOR_INDEX = Internal.createIndex(DSL.name("vendor_index"), Product.PRODUCT, new OrderField[] { Product.PRODUCT.NAME }, true);
    public static final Index VENDOR_NAME = Internal.createIndex(DSL.name("vendor_name"), Product.PRODUCT, new OrderField[] { Product.PRODUCT.NAME }, true);
}
