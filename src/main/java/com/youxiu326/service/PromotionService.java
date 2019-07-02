package com.youxiu326.service;

import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import com.youxiu326.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

public interface PromotionService {

    /**
     * <span color="red">结算方法</span>
     * <br>结算对象包含:
     * <br>1.商品优惠价格
     * <br>2.优惠后最终价格
     * <br>3.优惠信息
     * @param products 要结算的商品集合
     * @return Object 返回结算后的对象
     */
    public Map<String,Object> settlement(List<Product> products) throws ServiceException;

    /**
     * 查询可用的促销
     * @return
     */
    public List<Promotion> findUsablePromotions();

    /**
     * 过滤出可以参加指定促销的商品
     * @param promotion 指定促销
     * @param products 要过滤的商品集合
     * @return 返回过滤后的商品集合
     */
    public List<Product> filterProduct(Promotion promotion, List<Product> products);

    /**
     * 执行促销
     * @param promotions 促销集合
     * @param products 商品集合
     * @return
     */
    public List<PromotionResult> execute(List<Promotion> promotions, List<Product> products) throws ServiceException;

} 