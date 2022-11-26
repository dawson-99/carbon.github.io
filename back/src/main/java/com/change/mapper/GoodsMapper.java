package com.change.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.change.pojo.Goods;

import java.util.List;



public interface GoodsMapper extends BaseMapper<Goods> {

    public List<Goods> queryAllGoods();

    public Goods queryGoodsById(String goodsId);

}
