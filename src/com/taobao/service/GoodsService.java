package com.taobao.service;

import com.taobao.entity.AjaxParameter;
import com.taobao.entity.GoodsJson;

public interface GoodsService {
    public GoodsJson getGoods(AjaxParameter pars);
    public Integer test();
}
