package com.change.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.change.pojo.Goods;

import java.util.List;


public interface GoodsService extends IService<Goods> {

    public List<Goods> queryAllGoods();

    public Goods queryGoods(String goodsId);

    public void reduceScore(String score);

    public List<Goods> all();
}
