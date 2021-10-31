/*
 * This file is generated by jOOQ.
 */
package org.jooq.epam.contest.public_;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.epam.contest.public_.tables.Description;
import org.jooq.epam.contest.public_.tables.Product;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.description</code>.
     */
    public final Description DESCRIPTION = Description.DESCRIPTION;

    /**
     * The table <code>public.product</code>.
     */
    public final Product PRODUCT = Product.PRODUCT;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Description.DESCRIPTION,
            Product.PRODUCT
        );
    }
}