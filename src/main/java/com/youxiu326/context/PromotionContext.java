package com.youxiu326.context;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.entity.Promotion;

import java.util.Collection;
import java.util.List;

/**
 * 促销上下文
 */
public class PromotionContext {

    /**
     * 促销策略
     */
    private PromotionStrategy strategy;

    public static List<PromotionStrategy> strategys;

    public PromotionContext(){}

    public PromotionContext(Promotion promotion) {

    }

    public List<PromotionStrategy> getStrategys() {
        return strategys;
    }

    public void setStrategys(List<PromotionStrategy> strategys) {
        PromotionContext.strategys = strategys;
    }
}