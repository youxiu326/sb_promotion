package com.youxiu326.strategy;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 满足大于200
 * <br>八折促销
 */
@Component
public class RebateStrategy extends PromotionStrategy {

    /**
     * 指定促销类型为：REBATE
     * @return
     */
    @Override
    public Promotion.Type getType() {
        return Promotion.Type.REBATE;
    }

    @Override
    public List<PromotionResult> execute(Promotion promotion, List<Product> products) {
        return null;
    }

} 