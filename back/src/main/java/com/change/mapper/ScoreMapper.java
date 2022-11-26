package com.change.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.change.pojo.Score;


public interface ScoreMapper extends BaseMapper<Score> {

    public Score queryScore(String id);

    public void addTransportationScore(String id,double score);
    public void addTrafficScore(String id,double score);
    public void addEatingScore(String id,double score);
    public void addShoppingScore(String id,double score);
    public void addSleepingScore(String id,double score);
    public void addPlayingScore(String id,double score);
    public void addAnsweringScore(String id,double score);
    public void addCompensatingScore(String id,double score);
    public void updateTransportationScore(String id,double score);
    public void updateTrafficScore(String id,double score);
    public void updateEatingScore(String id,double score);
    public void updateShoppingScore(String id,double score);
    public void updateSleepingScore(String id,double score);
    public void updatePlayingScore(String id,double score);
    public void updateAnsweringScore(String id,double score);
    public void updateCompensatingScore(String id,double score);

    public void updatePoint(String id,double score);


}
