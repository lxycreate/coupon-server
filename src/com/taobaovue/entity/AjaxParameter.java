package com.taobaovue.entity;

import javax.servlet.http.HttpServletRequest;

//构造Ajax参数
public class AjaxParameter {
    private HttpServletRequest request;  //Ajax请求
    private Integer page_num;   //第几页
    private Integer page_size; //每页数据量
    private Integer start_column;//起始行数
    private Integer end_column;  //结束行数
    private String word;  //搜索内容
    private String order_by;   //排序方式
    private Integer cid;      //类别
    private Integer is_qiang; //淘抢购
    private Integer is_ju;    //聚划算
    private Integer is_tmall;  //天猫
    private Integer is_gold;   //金牌卖家
    private Integer is_ji;     //极有家
    private Integer is_hai;   //海淘
    private Integer is_yun;   //运费险
    private Integer sale_num;  //销量
    private Double dsr;        //评分
    private Double start_price;  //券后价格区间-最低价
    private Double end_price;   //券后价格区间-最高价

    public AjaxParameter(HttpServletRequest request) {
        this.request = request;
        is_gold = null;
    }
}
