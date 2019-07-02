package com.youxiu326.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品:
 *
 * <br>优惠金额    <span color="red">discountAmount</span>
 * <br>优惠后价格 -1(默认等于销售金额) <span color="red">finalAmount</span>
 * <br>销售价       <span color="red">amount</span>
 *
 */
public class Product implements Serializable {

    private String code;

    private String name;

    /**
     * 销售价
     */
    private BigDecimal amount;

    /**
     * 优惠了多少金额
     */
    private BigDecimal discountAmount;

    /**
     * 优惠后金额
     */
    private BigDecimal finalAmount = new BigDecimal("-1");


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

    /**
     * 优惠后金额(默认等于交易金额)
     * @return
     */
    public BigDecimal getFinalAmount() {
        if(finalAmount.compareTo(new BigDecimal("-1"))==0) {
            finalAmount = amount;
        }
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }
}