package com.youxiu326.service.impl;

import com.youxiu326.abst.PromotionStrategy;
import com.youxiu326.context.PromotionContext;
import com.youxiu326.entity.Product;
import com.youxiu326.entity.Promotion;
import com.youxiu326.entity.PromotionResult;
import com.youxiu326.exception.ServiceException;
import com.youxiu326.service.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 促销service
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionServiceImpl.class);


    //@Autowired
    //private ContextStartup contextStartup;

    @Autowired
    private ApplicationContext application;

    /**
     *  被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
     *  <br>类似于Serclet的inti()方法
     *  <br>被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行
     */
    @PostConstruct
    public void init() {
        PromotionContext.strategys =  application.getBeansOfType(PromotionStrategy.class).values();
    }

    public Object settlement(List<Product> products){


        //查询可用促销
        List<Promotion> promotions = findUsablePromotions();


        return null;
    }

    /**
     * 执行促销
     * @param promotions 促销集合
     * @param products 商品集合
     * @return
     */
    @Override
    public List<PromotionResult> execute(List<Promotion> promotions, List<Product> products) throws ServiceException {
        LOGGER.info("促销开始执行 促销数量:{} 商品数量:{}",promotions.size(),products.size());

        products.stream().forEach(it->LOGGER.info("执行促销商品信息->编号:{} 价格:{} 数量:{}",it.getCode(),it.getAmount(),it.getQuantity()));

        //返回促销结果
        List<PromotionResult> promotionResults = new ArrayList<PromotionResult>();

        //遍历执行促销
        for (Promotion promotion : promotions) {

            //根据传入的促销 得到对应的促销上下文
            PromotionContext context  = new PromotionContext(promotion);

            //过滤出可以参加该促销的商品
            List<Product> filterProductList = filterProduct(promotion, products);

            //根据策略模式 执行先对应的促销规则，返回促销结果
            List<PromotionResult> result = context.execute(filterProductList);

            promotionResults.addAll(result);

        }

        LOGGER.info("促销执行结束");
        return promotionResults;
    }

    /**
     * 查询可用的促销
     * @return
     */
    @Override
    public List<Promotion> findUsablePromotions(){
        //TODO 这儿你可以直接查询数据库

        List<Promotion> promotions = new ArrayList<>();
        Promotion p1 = new Promotion(Promotion.Type.FREEONE,"价格大于等于500免最低一件",null);
        Promotion p2 = new Promotion(Promotion.Type.REBATE,"大于200八折",null);
        Promotion p3 = new Promotion(Promotion.Type.REDUCE,"满100减10",null);
        promotions.add(p1);
        promotions.add(p2);
        promotions.add(p3);
        LOGGER.info("查询到可用促销数量：{}",promotions.size());
        return promotions;
    }

    /**
     * 过滤出可以参加指定促销的商品
     * @param promotion 指定促销
     * @param products 要过滤的商品集合
     * @return 返回过滤后的商品集合
     */
    public List<Product> filterProduct(Promotion promotion, List<Product> products){
        List<Product> list = new ArrayList<Product>();

        products.stream().forEach(it->{
            if (isMatching(promotion, it)) {
                list.add(it);
            }
        });

        return list;
    }

    /**
     * 判断该商品是否可以参加该促销
     * @param promotion
     * @param product
     * @return
     */
    private boolean isMatching(Promotion promotion, Product product) {
        //TODO 这里你应该查询数据库 1.看满足该促销的商品中是否包含该商品，2.如果该促销未设置商品默认所有商品都满足

        List<Product> products = null;

        //没有 所以商品都满足参加该促销的要求 返回true
        if(products == null || products.size() == 0)return true;

        //如果该商品在该促销商品集合内 则返回true 否则返回false
        long count = products.stream().filter(it->it.getCode().equals(product.getCode())).count();

        return count>0?true:false;
    }

}