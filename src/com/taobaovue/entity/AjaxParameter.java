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
    private String sort;   //排序方式
    private Integer goods_cid;      //类别
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
        initParameters();
        taskParameters();
        initColumn();
    }

    // 初始化参数
    public void initParameters() {
        page_num = null;
        page_size = null;
        start_column = null;
        end_column = null;
        word = null;
        sort = null;
        goods_cid = null;
        is_qiang = null;
        is_ju = null;
        is_tmall = null;
        is_gold = null;
        is_ji = null;
        is_hai = null;
        is_yun = null;
        sale_num = null;
        dsr = null;
        start_price = null;
        end_price = null;
    }

    // 获取参数
    public void taskParameters() {
        if (request.getParameter("word") != null) {
            word = request.getParameter("word");
        }
        if (request.getParameter("sort") != null) {
            sort = request.getParameter("sort");
        }
        if (request.getParameter("goods_cid") != null) {
            goods_cid = Integer.parseInt(request.getParameter("goods_cid"));
        }
        if (request.getParameter("is_qiang") != null) {
            is_qiang = Integer.parseInt(request.getParameter("is_qiang"));
        }
        if (request.getParameter("is_ju") != null) {
            is_ju = Integer.parseInt(request.getParameter("is_ju"));
        }
        if (request.getParameter("is_tmall") != null) {
            is_tmall = Integer.parseInt(request.getParameter("is_tmall"));
        }
        if (request.getParameter("is_gold") != null) {
            is_gold = Integer.parseInt(request.getParameter("is_gold"));
        }
        if (request.getParameter("is_ji") != null) {
            is_ji = Integer.parseInt(request.getParameter("is_ji"));
        }
        if (request.getParameter("is_hai") != null) {
            is_hai = Integer.parseInt(request.getParameter("is_hai"));
        }
        if (request.getParameter("is_yun") != null) {
            is_yun = Integer.parseInt(request.getParameter("is_yun"));
        }
        if (request.getParameter("sale_num") != null) {
            sale_num = Integer.parseInt(request.getParameter("sale_num"));
        }
        if (request.getParameter("dsr") != null) {
            dsr = Double.parseDouble(request.getParameter("dsr"));
        }
        if (request.getParameter("start_price") != null) {
            start_price = Double.parseDouble(request.getParameter("dsr"));
        }
        if (request.getParameter("end_price") != null) {
            end_price = Double.parseDouble(request.getParameter("end_price"));
        }
        if (request.getParameter("page_num") != null) {
            page_num = Integer.parseInt(request.getParameter("page_num"));
        }
        if (request.getParameter("page_size") != null) {
            page_size = Integer.parseInt(request.getParameter("page_size"));
        }
    }

    //取第几行到几行的数据
    public void initColumn() {
        start_column = (page_num - 1) * page_size;
        end_column = page_num * page_size - 1;
    }
}
