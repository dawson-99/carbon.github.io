package com.change.controller;

import com.change.pojo.Goods;
import com.change.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/queryAllGoods")
    public Map<String,Object> queryAllGoods(){
        List<Goods> goodsList = goodsService.queryAllGoods();
        Map<String,Object> map=new HashMap<>();
        System.out.println(goodsList);
        map.put("data",goodsList);
        return map;
    }

    @PostMapping("/queryGoods")
    public Double buyGoods(@RequestParam("goodsId")String goodsId){
        System.out.println(goodsId);
        Goods goods = goodsService.queryGoods(goodsId);
        return goods.getGoodsScore();
    }
}
