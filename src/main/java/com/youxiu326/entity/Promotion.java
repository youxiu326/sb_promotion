package com.youxiu326.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 促销实体类
 */
public class Promotion implements Serializable {

    /**
     *  促销类型
     * FREEONE  免最低一件
     * REBATE   八折
     * REDUCE   满100减20
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


} 