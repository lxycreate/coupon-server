package com.taobao.entity;

import javax.servlet.http.HttpServletRequest;

//构造Ajax参数
public class AjaxParameter {
    private HttpServletRequest request;  //Ajax请求
    private Integer page_num;   //第几页
    private Integer page_size; //每页数据量
    private Integer start_column;//起始行数
    private Integer end_column;  //取多少条
    private String word;  //搜索内容
    private String sort;   //排序
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
        page_num = 1;
        page_size = 20;
        start_column = 0;
        end_column = 20;
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
        if (request.getParameter("goods_cid") != null && checkIsInt(request.getParameter("goods_cid"))) {
            goods_cid = Integer.parseInt(request.getParameter("goods_cid"));
            if (goods_cid < 0 || goods_cid > 11) {
                goods_cid = null;
            }
        }
        if (request.getParameter("is_qiang") != null && checkZeroOrOne(request.getParameter("is_qiang"))) {
            is_qiang = Integer.parseInt(request.getParameter("is_qiang"));
        }
        if (request.getParameter("is_ju") != null && checkZeroOrOne(request.getParameter("is_ju"))) {
            is_ju = Integer.parseInt(request.getParameter("is_ju"));
        }
        if (request.getParameter("is_tmall") != null && checkZeroOrOne(request.getParameter("is_tmall"))) {
            is_tmall = Integer.parseInt(request.getParameter("is_tmall"));
        }
        if (request.getParameter("is_gold") != null && checkZeroOrOne(request.getParameter("is_gold"))) {
            is_gold = Integer.parseInt(request.getParameter("is_gold"));
        }
        if (request.getParameter("is_ji") != null && checkZeroOrOne(request.getParameter("is_ji"))) {
            is_ji = Integer.parseInt(request.getParameter("is_ji"));
        }
        if (request.getParameter("is_hai") != null && checkZeroOrOne(request.getParameter("is_hai"))) {
            is_hai = Integer.parseInt(request.getParameter("is_hai"));
        }
        if (request.getParameter("is_yun") != null && checkZeroOrOne(request.getParameter("is_yun"))) {
            is_yun = Integer.parseInt(request.getParameter("is_yun"));
        }
        if (request.getParameter("sale_num") != null && checkIsInt(request.getParameter("sale_num"))) {
            sale_num = Integer.parseInt(request.getParameter("sale_num"));
        }
        if (request.getParameter("dsr") != null && checkIsDouble(request.getParameter("dsr"))) {
            dsr = Double.parseDouble(request.getParameter("dsr"));
            if (dsr > 5.0) {
                dsr = 5.0;
            }
        }
        if (request.getParameter("start_price") != null && checkIsDouble(request.getParameter("start_price"))) {
            start_price = Double.parseDouble(request.getParameter("start_price"));
            if (start_price < 0) {
                start_price = 0.1;
            }
        }
        if (request.getParameter("end_price") != null && checkIsDouble(request.getParameter("end_price"))) {
            end_price = Double.parseDouble(request.getParameter("end_price"));
            if (end_price < 0) {
                end_price = 10000.0;
            }
        }
        if (request.getParameter("page_num") != null && checkIsInt(request.getParameter("page_num"))) {
            page_num = Integer.parseInt(request.getParameter("page_num"));
        }
        if (request.getParameter("page_size") != null && checkIsInt(request.getParameter("page_size"))) {
            page_size = Integer.parseInt(request.getParameter("page_size"));
            if (page_size > 100) {
                page_size = 100;
            }
        }
    }

    //取第几行到几行的数据
    public void initColumn() {
        start_column = (page_num - 1) * page_size;
        end_column = page_size;
    }

    // 检查是否为0或1
    public Boolean checkZeroOrOne(String s) {
        if (s.equals("0") || s.equals("1")) {
            return true;
        }
        return false;
    }

    // 检查是否为整数
    public Boolean checkIsInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 检查是否为小数
    public Boolean checkIsDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Integer getPage_num() {
        return page_num;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
