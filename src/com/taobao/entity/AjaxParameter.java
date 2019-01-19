package com.taobao.entity;

import javax.servlet.http.HttpServletRequest;

//构造Ajax参数
public class AjaxParameter {
    private HttpServletRequest request;  //Ajax请求
    private Integer page_num;   //第几页
    private Integer page_size; //每页数据量
    private Integer start_column;//起始行数
    private Integer end_column;  //结束行数
    private String word;  //搜索内容
    private String sort;   //排序
    private String sort_word; //排序字段
    private String sort_type; //排序方式asc or desc
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
        sort_word = null;
        sort_type = null;
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
            String s[] = sort.split(" ");
            if(s.length==2){
                sort_word = s[0];
                sort_type = s[1];
            }
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
            start_price = Double.parseDouble(request.getParameter("start_price"));
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
        end_column = page_size;
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

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getStart_column() {
        return start_column;
    }

    public void setStart_column(Integer start_column) {
        this.start_column = start_column;
    }

    public Integer getEnd_column() {
        return end_column;
    }

    public void setEnd_column(Integer end_column) {
        this.end_column = end_column;
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

    public Integer getGoods_cid() {
        return goods_cid;
    }

    public void setGoods_cid(Integer goods_cid) {
        this.goods_cid = goods_cid;
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

    public Integer getSale_num() {
        return sale_num;
    }

    public void setSale_num(Integer sale_num) {
        this.sale_num = sale_num;
    }

    public Double getDsr() {
        return dsr;
    }

    public void setDsr(Double dsr) {
        this.dsr = dsr;
    }

    public Double getStart_price() {
        return start_price;
    }

    public void setStart_price(Double start_price) {
        this.start_price = start_price;
    }

    public Double getEnd_price() {
        return end_price;
    }

    public void setEnd_price(Double end_price) {
        this.end_price = end_price;
    }
}
