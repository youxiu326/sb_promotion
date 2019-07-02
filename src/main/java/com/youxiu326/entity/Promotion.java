package com.youxiu326.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 促销实体类
 */
public class Promotion implements Serializable {

    /**
     *  <span color="red">促销类型:</span>
     *  <br>FREEONE  免最低一件
     *  <br>REBATE   八折
     *  <br>REDUCE   满100减20
     */
    public static enum Type{
        FREEONE,REBATE,REDUCE
    }

    private Type type;

    private String name;

    /**
     * 哪些商品应用促销
     */
    private List<Product> products;

    public Promotion(){}
    public Promotion(Type type, String name,List<Product> products) {
        this.type = type;
        this.name = name;
        this.products = products;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}