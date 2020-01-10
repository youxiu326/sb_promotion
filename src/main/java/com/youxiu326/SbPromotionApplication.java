package com.youxiu326;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SbPromotionApplication{

    public static void main(String[] args) {
        SpringApplication.run(SbPromotionApplication.class, args);
    }

}
