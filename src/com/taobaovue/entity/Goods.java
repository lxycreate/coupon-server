package com.taobaovue.entity;

public class Goods {

    private String goodsId;        //商品ID
    private String goodsPic;       //商品主图
    private String goodsTitle;     //商品标题
    private String goodsShortTitle; //商品短标题
    private Integer goodsType;     //商品分类
    private Double goodsPrice;     //商品价格
    private Integer goodsSaleNum;  //商品销量
    private String couponId;       //券ID
    private String sellerId;       //店铺ID
    private Double couponApply;    //优惠券满多少使用
    private Double couponAmount;   //优惠券面值
    private String endTime;        //优惠券结束时间
    private Double dsr;            //DSR描述评分
    private Integer isTmall;       //是否天猫
    private String goodUrl;        //商品链接

    public Goods() {
        goodsId = "";
        goodsPic = "";
        goodsTitle = "";
        goodsShortTitle = "";
        goodsType = 0;
        goodsPrice = 0.0;
        goodsSaleNum = 0;
        couponId = "";
        sellerId = "";
        couponApply = 0.0;
        couponAmount = 0.0;
        endTime = "";
        dsr = 0.0;
        isTmall = 1;
        goodUrl = "";
    }

    //商品ID
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    //商品主图
    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    //商品标题
    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    //商品短标题
    public String getGoodsShortTitle() {
        return goodsShortTitle;
    }

    public void setGoodsShortTitle(String goodsShortTitle) {
        this.goodsShortTitle = goodsShortTitle;
    }

    //商品分类
    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    //商品价格
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    //商品销量
    public Integer getGoodsSaleNum() {
        return goodsSaleNum;
    }

    public void setGoodsSaleNum(Integer goodsSaleNum) {
        this.goodsSaleNum = goodsSaleNum;
    }

    //优惠券ID
    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    //店铺ID
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    //优惠券满多少减
    public Double getCouponApply() {
        return couponApply;
    }

    public void setCouponApply(Double couponApply) {
        this.couponApply = couponApply;
    }

    //优惠券大小
    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    //优惠券结束时间
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    //DSR评分
    public Double getDsr() {
        return dsr;
    }

    public void setDsr(Double dsr) {
        this.dsr = dsr;
    }

    //是否天猫
    public Integer getIsTmall() {
        return isTmall;
    }

    public void setIsTmall(Integer isTmall) {
        this.isTmall = isTmall;
        createGoodUrl(isTmall);
    }

    //商品链接
    public void createGoodUrl(Integer isTmall) {
        if (isTmall == 1) {
            goodUrl = "https://item.tmall.com/item.htm?id=" + goodsId;
        } else {
            goodUrl = "https://item.taobao.com/item.htm?id=" + goodsId;
        }
    }
}
