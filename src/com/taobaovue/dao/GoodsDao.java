package com.taobaovue.dao;

import com.taobaovue.entity.AjaxParameter;
import com.taobaovue.entity.SqlGoods;

import java.util.List;

public interface GoodsDao {

    // 数据总条数
    public Integer getGoodsNum();

    // 全网商品，获取数据
    public List<SqlGoods> getGoods(AjaxParameter pars);
}
