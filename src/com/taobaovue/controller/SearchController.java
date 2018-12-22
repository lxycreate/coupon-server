package com.taobaovue.controller;

import com.taobaovue.entity.GoodsJson;
import com.taobaovue.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class SearchController {
    @Autowired
    GoodsService search;

    @RequestMapping(value = "/getGoods/searchGoods", method = RequestMethod.GET)
    public @ResponseBody
    GoodsJson searchGoods(@RequestParam("pageNum") Integer pageNum, @RequestParam("searchWord") String searchWord, @RequestParam("sortWay") String sortWay) {
      return search.searchGoods(pageNum, searchWord, sortWay);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody Integer test(@RequestParam("test") Integer test){
        return search.test();
    }

}
