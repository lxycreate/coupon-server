package com.taobaovue.service;

import com.taobaovue.entity.AjaxParameter;
import com.taobaovue.entity.GoodsJson;

public interface GoodsService {
    public GoodsJson getGoods(AjaxParameter pars);
    public Integer test();
}
