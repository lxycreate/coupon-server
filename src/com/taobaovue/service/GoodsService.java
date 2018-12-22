package com.taobaovue.service;

import com.taobaovue.entity.GoodsJson;

public interface GoodsService {
    public final String apiKey = "app_key=e962172ec1fed525";
    public final String baseTaoUrl = "https://api.taokezhushou.com/api/v1/";
    public GoodsJson searchGoods(Integer pageNum, String searchWord, String sortWay);
    public Integer test();
}
