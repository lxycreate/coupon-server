package com.taobaovue.entity;

import java.util.List;

public class GoodsJson {
    private String code;    //代码
    private String msg;     //执行信息
    private Integer total;  //数据总量
    private List<Goods> goods;

    public GoodsJson() {
        code = "404";
        msg = "错误";
        total = 0;
        goods = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
