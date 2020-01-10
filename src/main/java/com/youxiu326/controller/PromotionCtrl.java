package com.youxiu326.controller;


import com.youxiu326.entity.Product;
import com.youxiu326.exception.ServiceException;
import com.youxiu326.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 促销controller
 */
@Controller
public class PromotionCtrl {

    @Autowired
    private PromotionService service;

    @GetMapping("/index")
    public String index(){

        for (int i = 0; i < 1000; i++) {
            service.asyncMethod();
        }
        return "index";
    }


    @PostMapping("/data")
    @ResponseBody
    public Map data(@RequestBody List<Product> products){
        Map map = null;
        try {
            map = service.settlement(products);
        } catch (ServiceException e) {
            return null;
        }
        return map;
    }

}
