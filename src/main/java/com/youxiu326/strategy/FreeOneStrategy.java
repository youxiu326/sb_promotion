package com.youxiu326.strategy;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 满足价格大于等于500
 * <br>减免价格最低一件商品促销
 */
@Component
public class FreeOneStrategy extends PromotionStrategy {

    /**
     * 指定促销类型为：FREEONE
     * @return
     */
    @Override
    public Promotion.Type getType() {
        return Promotion.Type.FREEONE;
    }

    @Override
    public List<PromotionResult> execute(Promotion promotion, List<Product> products) {
        return null;
    }
}