/*
 * This file is generated by jOOQ.
 */
package org.jooq.epam.contest.public_.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer    id;
    private final String     name;
    private final BigDecimal price;
    private final Integer    categoryId;
    private final String     vendor;
    private final String     sn;
    private final String     owner;

    public Product(Product value) {
        this.id = value.id;
        this.name = value.name;
        this.price = value.price;
        this.categoryId = value.categoryId;
        this.vendor = value.vendor;
        this.sn = value.sn;
        this.owner = value.owner;
    }

    public Product(
        Integer    id,
        String     name,
        BigDecimal price,
        Integer    categoryId,
        String     vendor,
        String     sn,
        String     owner
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.vendor = vendor;
        this.sn = sn;
        this.owner = owner;
    }

    /**
     * Getter for <code>public.product.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.product.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>public.product.price</code>.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Getter for <code>public.product.category_id</code>.
     */
    public Integer getCategoryId() {
        return this.categoryId;
    }

    /**
     * Getter for <code>public.product.vendor</code>.
     */
    public String getVendor() {
        return this.vendor;
    }

    /**
     * Getter for <code>public.product.sn</code>.
     */
    public String getSn() {
        return this.sn;
    }

    /**
     * Getter for <code>public.product.owner</code>.
     */
    public String getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Product (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(price);
        sb.append(", ").append(categoryId);
        sb.append(", ").append(vendor);
        sb.append(", ").append(sn);
        sb.append(", ").append(owner);

        sb.append(")");
        return sb.toString();
    }
}
