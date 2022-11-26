package com.change.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.change.pojo.Score;

public interface ScoreService extends IService<Score> {

    public double queryScore(String id);

    public Score queryUserCarbon(String userId);

    public double shop(double weight,int box,int bag,int method,double distance);

    public String buyGoods(double price,String userId);


    public String addTransportationScore(double score,String userId);

    public String addFoodScore(double score,String userId);

    public String addPlayingScore(double score, String userId);

    public String addTrafficScore(double score, String userId);

    public String addShoppingScore(double score, String userId);

    public String addSleepingScore(double score, String userId);

    public String addAnsweringScore(double score,String userId);

    public String addMoney(double money,String userId);

}
