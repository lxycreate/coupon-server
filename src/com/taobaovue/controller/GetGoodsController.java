package com.taobaovue.controller;

import com.taobaovue.entity.GoodsJson;
import com.taobaovue.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller

public class GetGoodsController {
    @Autowired
    GoodsService goods_service;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/getGoods", method = RequestMethod.GET)
    public @ResponseBody
    GoodsJson getGoods() {
        
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    Integer test(@RequestParam("test") Integer test) {
        System.out.print(test);
        return goods_service.test();
    }

}
