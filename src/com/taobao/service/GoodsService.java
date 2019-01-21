package com.taobao.service;

import com.taobao.entity.AjaxParameter;
import com.taobao.entity.Goods;
import com.taobao.entity.GoodsDetailJson;
import com.taobao.entity.GoodsJson;

public interface GoodsService {
    //获取商品
    GoodsJson getGoods(AjaxParameter pars);

    //获取商品详情
    GoodsDetailJson getGoodsDetail(String goods_id);

    //测试
    Integer test();
}
