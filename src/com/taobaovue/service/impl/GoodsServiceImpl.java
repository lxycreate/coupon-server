package com.taobaovue.service.impl;

import com.taobaovue.dao.GoodsDao;
import com.taobaovue.entity.AjaxParameter;
import com.taobaovue.entity.GoodsJson;
import com.taobaovue.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goods_dao;


    @Override
    public GoodsJson getGoods(AjaxParameter pars) {
        System.out.println(goods_dao.getGoods(pars));
        return null;
    }

    @Override
    public Integer test() {
        return null;
    }
}
