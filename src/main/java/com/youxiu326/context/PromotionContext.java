package com.youxiu326.context;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import com.youxiu326.exception.ServiceException;
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

    /**
     * 当前促销
     */
    private Promotion promotion;

    public static Collection<PromotionStrategy> strategys;

    public PromotionContext(){}

    public PromotionContext(Promotion promotion) throws ServiceException {

        this.promotion = promotion;
        //初始化促销列表
        if(strategys == null)throw new ServiceException("无可用促销");

        //根据传入的促销 找到对应的促销策略 【strategy】
        strategy = strategys.stream().filter(it->it.getType() == promotion.getType()).findFirst().orElse(null);

        if(strategy == null) throw new ServiceException("找不到符合促销类型");
    }

    public List<PromotionResult> execute(List<Product> products) throws ServiceException{
        return strategy.execute(promotion, products);
    }

    public Collection<PromotionStrategy> getStrategys() {
        return strategys;
    }

    public void setStrategys(Collection<PromotionStrategy> strategys) {
        PromotionContext.strategys = strategys;
    }
}