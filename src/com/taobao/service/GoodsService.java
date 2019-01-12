package com.taobao.service;

import com.taobao.entity.AjaxParameter;
import com.taobao.entity.GoodsDetailJson;
import com.taobao.entity.GoodsJson;

public interface GoodsService {
    //获取商品
    public GoodsJson getGoods(AjaxParameter pars);
    //获取商品详情
    public GoodsDetailJson getGoodsDetail(String goods_id);
    //测试
    public Integer test();
}
