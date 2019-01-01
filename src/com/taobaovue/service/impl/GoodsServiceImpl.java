package com.taobaovue.service.impl;

import com.taobaovue.dao.GoodsDao;
import com.taobaovue.entity.AjaxParameter;
import com.taobaovue.entity.Goods;
import com.taobaovue.entity.GoodsJson;
import com.taobaovue.entity.SqlGoods;
import com.taobaovue.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goods_dao;

    // 全网商品，获取数据
    @Override
    public GoodsJson getGoods(AjaxParameter pars) {
        List<SqlGoods> sql_goods = goods_dao.getGoods(pars);

        return createJson(sql_goods);
    }

    public GoodsJson createJson(List<SqlGoods> sql_goods) {
        List<Goods> goods_list = new ArrayList<Goods>();
        GoodsJson temp_json = new GoodsJson();
        for (int i = 0; i < sql_goods.size(); ++i) {
            Goods temp = new Goods();
            SqlGoods temp_sql = sql_goods.get(i);
            //图片
            temp.setGoods_pic(temp_sql.getGoods_pic());
            //标题
            temp.setGoods_title(temp_sql.getGoods_title());
            //商品链接
            temp.setGoods_url(temp_sql.getGoods_url());
            //分类
            temp.setCid(temp_sql.getGoods_cid());
            //价格
            temp.setGoods_price(temp_sql.getGoods_price());
            //券后价
            temp.setAfter_coupon(temp_sql.getAfter_coupon());
            //评分
            temp.setDsr(temp_sql.getDsr());
            //淘抢购
            temp.setIs_qiang(temp_sql.getIs_qiang());
            //聚划算
            temp.setIs_ju(temp_sql.getIs_ju());
            //天猫
            temp.setIs_tmall(temp_sql.getIs_tmall());
            //金牌卖家
            temp.setIs_gold(temp_sql.getIs_gold());
            //海淘
            temp.setIs_hai(temp_sql.getIs_hai());
            //极有家
            temp.setIs_ji(temp_sql.getIs_ji());
            //运费险
            temp.setIs_yun(temp_sql.getIs_yun());
            //优惠券链接
            temp.setCoupon_url(temp_sql.getCoupon_url());
            //销量
            temp.setGoods_sale(temp_sql.getGoods_sale());
            //券的面值
            temp.setCoupon_price(temp_sql.getCoupon_price());
            goods_list.add(temp);
        }
        temp_json.setGoods(goods_list);
        return temp_json;
    }

    @Override
    public Integer test() {
        return null;
    }
}
