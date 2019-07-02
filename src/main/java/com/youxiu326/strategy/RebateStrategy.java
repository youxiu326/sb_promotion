package com.youxiu326.strategy;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
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

        List<PromotionResult> results = new ArrayList<PromotionResult>();

        //计算总金额 总数量
        double totalAmount = products.stream().mapToDouble(it->(
                (it.getAmount().multiply(new BigDecimal(it.getQuantity().toString())))).subtract(it.getDiscountAmount()).doubleValue()
        ).sum();
        int totalQuantity =  products.stream().mapToInt(it->it.getQuantity()).sum();

        //TODO 这儿简单处理定死了规则
        //不满足促销规则的返回空促销
        if (totalAmount<=500){
            return null;
        }

        //获得可优惠金额
        double reduceAmount = totalAmount * 0.8;

        //平摊金额
        sharedAmount(products, new BigDecimal(reduceAmount+""));

        //创建减免促销信息
        PromotionResult result = new PromotionResult();
        result.setName(promotion.getName());
        result.setType(Promotion.Type.REBATE);
        result.setResult(reduceAmount);
        results.add(result);

        return results;
    }

} 