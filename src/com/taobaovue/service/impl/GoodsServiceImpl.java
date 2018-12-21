package com.taobaovue.service.impl;

import com.taobaovue.entity.Goods;
import com.taobaovue.entity.GoodsJson;
import com.taobaovue.service.GoodsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public GoodsJson searchGoods(Integer pageNum, String searchWord, String sortWay) {
        //操作类型
        String opType = "search?";
        //请求接口
        String urlStr = baseTaoUrl + opType + apiKey + "&page=" + pageNum + "&q=" + searchWord + "&sort=" + sortWay;
        return getGoods(urlStr);
    }

    //获取商品数据
    public GoodsJson getGoods(String urlStr) {
        //要返回的Json数据
        GoodsJson jsonData = new GoodsJson();
        //存放处理后的商品列表
        List<Goods> goodsList = new ArrayList<Goods>();
        //存放返回的数据
        StringBuffer strb = new StringBuffer();
        //存放Json数据
        JSONObject jsonObject = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            //POST方式必须设置下面两行
            //允许输出
            httpUrlConn.setDoOutput(true);
            //允许输入
            httpUrlConn.setDoInput(true);

            //不用缓存
            httpUrlConn.setUseCaches(false);
            //设置请求方式
            httpUrlConn.setRequestMethod("GET");
            //设置请求头
            httpUrlConn.setRequestProperty("Content-type", "application/json");
            // 设置文件字符集:
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            //禁止重定向
            httpUrlConn.setInstanceFollowRedirects(false);


            httpUrlConn.connect();

            if (HttpURLConnection.HTTP_OK == httpUrlConn.getResponseCode()) {
                System.out.println("连接成功");
                //接收数据
                InputStream inputData = httpUrlConn.getInputStream();
                try {
                    String readLine;
                    InputStreamReader tempInputReader = new InputStreamReader(inputData, "UTF-8");
                    BufferedReader responseReader = new BufferedReader(tempInputReader);
                    while ((readLine = responseReader.readLine()) != null) {
                        strb.append(readLine).append("\n");
                    }
                    //释放资源
                    inputData.close();
                    responseReader.close();
                    tempInputReader.close();
                    httpUrlConn.disconnect();

                    //输出结果
                    jsonObject = JSONObject.fromObject(strb.toString());
                    //处理返回的Json数据
                    jsonData = taskGoodsJson(jsonData, jsonObject, goodsList);

                } catch (Exception e) {
                    jsonData.setCode("600");
                    jsonData.setMsg("数据装载错误");
                    System.out.println("数据装载错误");
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            jsonData.setCode("500");
            jsonData.setMsg("连接出错");
            System.out.println("连接出错");
            e.printStackTrace();
        }
        return jsonData;
    }

    //处理返回的商品数据
    public GoodsJson taskGoodsJson(GoodsJson data, JSONObject jsonObject, List<Goods> goodsList) {
        JSONArray temp = jsonObject.getJSONArray("data");
        for (int i = 0; i < temp.size(); ++i) {
            Goods tempGoods = new Goods();
            JSONObject good = temp.getJSONObject(i);
            tempGoods.setGoodsId(good.getString("goods_id"));
            tempGoods.setGoodsPic(good.getString("goods_pic"));
            tempGoods.setGoodsTitle(good.getString("goods_title"));
            tempGoods.setGoodsShortTitle(good.getString("goods_short_title"));
            tempGoods.setGoodsType(good.getInt("goods_cate_id"));
            tempGoods.setGoodsPrice(good.getDouble("goods_price"));
            tempGoods.setGoodsSaleNum(good.getInt("goods_sale_num"));
            tempGoods.setCouponId(good.getString("coupon_id"));
            tempGoods.setSellerId(good.getString("seller_id"));
            tempGoods.setCouponApply(good.getDouble("coupon_apply_amount"));
            tempGoods.setCouponAmount(good.getDouble("coupon_amount"));
            tempGoods.setEndTime(good.getString("coupon_end_time"));
            tempGoods.setDsr(good.getDouble("dsr"));
            goodsList.add(tempGoods);
        }
        data.setCode(jsonObject.getString("code"));
        data.setMsg(jsonObject.getString("msg"));
        data.setTotal(jsonObject.getInt("total"));
        data.setGoods(goodsList);
        return data;
    }

}
