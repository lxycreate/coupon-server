package com.taobao.entity;

import java.math.BigDecimal;

//返回到网页用的类
public class Goods {

    private String goods_id;   //商品ID
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

    public void transForm(SqlGoods temp_sql) {
        if (temp_sql != null) {
            this.setGoods_id(temp_sql.getGoods_id());
            //图片
            this.setGoods_pic(temp_sql.getGoods_pic());
            //标题
            this.setGoods_title(temp_sql.getGoods_title());
            //商品链接
            this.setGoods_url(temp_sql.getGoods_url());
            //分类
            this.setCid(temp_sql.getGoods_cid());
            //价格
            this.setGoods_price(temp_sql.getGoods_price());
            //券后价
            this.setAfter_coupon(temp_sql.getAfter_coupon());
            //评分
            this.setDsr(temp_sql.getDsr());
            //淘抢购
            this.setIs_qiang(temp_sql.getIs_qiang());
            //聚划算
            this.setIs_ju(temp_sql.getIs_ju());
            //天猫
            this.setIs_tmall(temp_sql.getIs_tmall());
            //金牌卖家
            this.setIs_gold(temp_sql.getIs_gold());
            //海淘
            this.setIs_hai(temp_sql.getIs_hai());
            //极有家
            this.setIs_ji(temp_sql.getIs_ji());
            //运费险
            this.setIs_yun(temp_sql.getIs_yun());
            //优惠券链接
            this.setCoupon_url(temp_sql.getCoupon_url());
            //销量
            this.setGoods_sale(temp_sql.getGoods_sale());
            //券的面值
            this.setCoupon_price(temp_sql.getCoupon_price());
        }
    }

    //保留一位小数
    public Double keepOneDecimal(Double temp) {
        BigDecimal bd = new BigDecimal(temp);
        Double result = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
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
