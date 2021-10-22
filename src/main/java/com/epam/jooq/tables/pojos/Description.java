/*
 * This file is generated by jOOQ.
 */
package com.epam.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Description implements Serializable {

    private static final long serialVersionUID = 1272207571;

    private final Long    id;
    private final Integer productId;
    private final Integer descr;

    public Description(Description value) {
        this.id = value.id;
        this.productId = value.productId;
        this.descr = value.descr;
    }

    public Description(
        Long    id,
        Integer productId,
        Integer descr
    ) {
        this.id = id;
        this.productId = productId;
        this.descr = descr;
    }

    public Long getId() {
        return this.id;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public Integer getDescr() {
        return this.descr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Description (");

        sb.append(id);
        sb.append(", ").append(productId);
        sb.append(", ").append(descr);

        sb.append(")");
        return sb.toString();
    }
}