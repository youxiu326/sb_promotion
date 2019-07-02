package com.youxiu326;

import com.youxiu326.service.PromotionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbPromotionApplicationTests {


    @Autowired
    PromotionService service;

    @Test
    public void contextLoads() {

        service.settlement(null);

    }

}
