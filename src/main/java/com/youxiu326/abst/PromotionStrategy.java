package com.youxiu326.abst;

import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;

import java.util.List;

/**
 * 促销抽象类
 * 定义公共方法，让子类继承
 * 定义抽象方法，让子类实现
 */
public abstract class PromotionStrategy {

    public abstract Promotion.Type getType();

    public abstract List<PromotionResult> execute();

} 