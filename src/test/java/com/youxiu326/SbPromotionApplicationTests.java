package com.youxiu326;

import com.youxiu326.entity.Product;
import com.youxiu326.exception.ServiceException;
import com.youxiu326.service.PromotionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbPromotionApplicationTests {

    @Autowired
    PromotionService service;

    @Test
    public void contextLoads() throws ServiceException {

        List<Product> products = new ArrayList<>();

        Product p1 = new Product("YX001", "牙刷", new BigDecimal("50"), 2);
        Product p2 = new Product("YX002", "电视", new BigDecimal("200"), 2);
        Product p3 = new Product("YX003", "圆珠笔", new BigDecimal("20"), 2);
        Product p4 = new Product("YX004", "水杯", new BigDecimal("60"), 1);
        Product p5 = new Product("YX005", "充电宝", new BigDecimal("400"), 1);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);

        Map<String, Object> result = service.settlement(products);

        System.out.println(result);

    }

}
