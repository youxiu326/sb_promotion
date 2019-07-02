package com.youxiu326.entity;

import java.io.Serializable;

/**
 * 促销结果
 */
public class PromotionResult implements Serializable {

    private String name;

    private Promotion.Type type;

    private Object result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Promotion.Type getType() {
        return type;
    }

    public void setType(Promotion.Type type) {
        this.type = type;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}