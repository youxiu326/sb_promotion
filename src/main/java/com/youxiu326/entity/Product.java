package com.youxiu326.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品
 */
public class Product implements Serializable {

    private String code;

    private String name;

    /**
     * 销售价
     */
    private BigDecimal amount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    private Integer quantity;

    public Product(){}

    public Product(String code, String name, BigDecimal amount, Integer quantity) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
}