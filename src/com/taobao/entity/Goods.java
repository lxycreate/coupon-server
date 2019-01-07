package com.taobao.entity;

import java.math.BigDecimal;

//返回到网页用的类
public class Goods {

    private String goods_pic; //商品图片
    private String goods_title; //商品标题
    private String goods_url;  //商品链接
    private Integer cid;  //商品目录
    private Double goods_price; // 商品价格
    private Double after_coupon;   //券后价
    private Double coupon_price;  //优惠券面值
    private Double dsr;  //评分
    private Integer is_qiang;  //淘抢购
    private Integer is_ju;    //聚划算
    private Integer is_tmall;  //天猫
    private Integer is_gold;   //金牌卖家
    private Integer is_ji;     //极有家
    private Integer is_hai;   //海淘
    private Integer is_yun;   //运费险
    private String coupon_url;//优惠券链接
    private Integer goods_sale; //商品销量

    public Goods() {

    }

    //保留一位小数
    public Double keepOneDecimal(Double temp) {
        BigDecimal bd = new BigDecimal(temp);
        Double result = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_url() {
        return goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = keepOneDecimal(goods_price);
    }

    public Double getAfter_coupon() {
        return after_coupon;
    }

    public void setAfter_coupon(Double after_coupon) {
        this.after_coupon = keepOneDecimal(after_coupon);
    }

    public Double getCoupon_price() {
        return coupon_price;
    }

    public void setCoupon_price(Double coupon_price) {
        this.coupon_price = Math.floor(coupon_price);
    }

    public Double getDsr() {
        return dsr;
    }

    public void setDsr(Double dsr) {
        this.dsr = keepOneDecimal(dsr);
    }

    public Integer getIs_qiang() {
        return is_qiang;
    }

    public void setIs_qiang(Integer is_qiang) {
        this.is_qiang = is_qiang;
    }

    public Integer getIs_ju() {
        return is_ju;
    }

    public void setIs_ju(Integer is_ju) {
        this.is_ju = is_ju;
    }

    public Integer getIs_tmall() {
        return is_tmall;
    }

    public void setIs_tmall(Integer is_tmall) {
        this.is_tmall = is_tmall;
    }

    public Integer getIs_gold() {
        return is_gold;
    }

    public void setIs_gold(Integer is_gold) {
        this.is_gold = is_gold;
    }

    public Integer getIs_ji() {
        return is_ji;
    }

    public void setIs_ji(Integer is_ji) {
        this.is_ji = is_ji;
    }

    public Integer getIs_hai() {
        return is_hai;
    }

    public void setIs_hai(Integer is_hai) {
        this.is_hai = is_hai;
    }

    public Integer getIs_yun() {
        return is_yun;
    }

    public void setIs_yun(Integer is_yun) {
        this.is_yun = is_yun;
    }

    public String getCoupon_url() {
        return coupon_url;
    }

    public void setCoupon_url(String coupon_url) {
        this.coupon_url = coupon_url;
    }

    public Integer getGoods_sale() {
        return goods_sale;
    }

    public void setGoods_sale(Integer goods_sale) {
        this.goods_sale = goods_sale;
    }
}
