package com.taobaovue.entity;

import java.util.List;

public class GoodsJson {
    private List<Goods> goods;

    public GoodsJson() {
        goods = null;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
