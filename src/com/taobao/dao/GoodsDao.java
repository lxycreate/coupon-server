package com.taobao.dao;

import com.taobao.entity.AjaxParameter;
import com.taobao.entity.SqlGoods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {

    // 数据总条数
    public Integer getGoodsNum(AjaxParameter pars);

    // 全网商品,获取数据
    public List<SqlGoods> getGoods(AjaxParameter pars);

    // 获取商品详情
    public List<SqlGoods> getGoodsDetail(String goods_id);

    // 获取当前分类商品的总量
    public Integer getGoodsCountByCid(Integer cid);

    // 获取相关推荐商品
    public List<SqlGoods> getRecommendList(Map temp);
}
