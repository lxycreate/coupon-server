package com.taobao.entity;

import java.util.List;

public class GoodsDetailJson {
    private Goods goods_detail;
    private List<Goods> goods_list;

    public GoodsDetailJson() {
        goods_detail = null;
        goods_list = null;
    }

    public Goods getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(Goods goods_detail) {
        this.goods_detail = goods_detail;
    }

    public List<Goods> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<Goods> goods_list) {
        this.goods_list = goods_list;
    }
}
