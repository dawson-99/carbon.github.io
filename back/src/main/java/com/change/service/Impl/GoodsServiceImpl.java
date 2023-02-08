package com.change.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.change.mapper.GoodsMapper;
import com.change.pojo.Goods;
import com.change.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryAllGoods() {


        List<Goods> goodsList = goodsMapper.queryAllGoods();
        return goodsList;
    }

    @Override
    public Goods queryGoods(String goodsId) {
        Goods goods = goodsMapper.queryGoodsById(goodsId);
        if (goods==null){
            System.out.println("未查询到商品");
        }
        return goods;
    }

    @Override
    public void reduceScore(String score) {

    }

    @Override
    public List<Goods> all() {
        return list();
    }
}
