package com.youxiu326.strategy;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 满足满100
 * <br>减10促销
 */
@Component
public class ReduceStrategy extends PromotionStrategy {

    /**
     * 指定促销类型为：REDUCE
     * @return
     */
    @Override
    public Promotion.Type getType() {
        return Promotion.Type.REDUCE;
    }

    @Override
    public List<PromotionResult> execute(Promotion promotion, List<Product> products) {
        return null;
    }

} 