package com.taobao.controller;

import com.taobao.entity.AjaxParameter;
import com.taobao.entity.GoodsJson;
import com.taobao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

//部分跨域
//@CrossOrigin(origins = "*", maxAge = 3600)
@Controller

public class GetGoodsController {


    @Autowired
    GoodsService goods_service;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/getGoods", method = RequestMethod.GET)
    public @ResponseBody
    GoodsJson getGoods() {
        AjaxParameter temp = new AjaxParameter(request);
        return goods_service.getGoods(temp);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    Integer test(@RequestParam("test") Integer test) {
        System.out.print(test);
        return goods_service.test();
    }

}
