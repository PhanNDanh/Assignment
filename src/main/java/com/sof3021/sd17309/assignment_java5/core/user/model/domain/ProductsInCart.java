package com.sof3021.sd17309.assignment_java5.core.user.model.domain;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class ProductsInCart {

    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public BigDecimal getIntoMoney() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
