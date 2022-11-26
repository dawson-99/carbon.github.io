package com.change.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.change.mapper.ScoreMapper;
import com.change.pojo.Score;
import com.change.service.ScoreService;
import com.change.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private UserService userService;

    @Override
    public String addTransportationScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addTransportationScore(userId,score);
                scoreMapper.updatePoint(userId,200-score*0.5);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                score1.setTransportation(score1.getTransportation()+score);
                score1.setPoint(score1.getPoint()-score*0.5);
                //System.out.println(score1.addAll());
                scoreMapper.updateTransportationScore(userId,score1.getTransportation());
                scoreMapper.updatePoint(userId,score1.getPoint());
            }
            return "true";
        }
    }

    @Override
    public String addFoodScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addEatingScore(userId,score);
                scoreMapper.updatePoint(userId,200-score*0.5);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                score1.setEating(score1.getEating()+score);
                score1.setPoint(score1.getPoint()-score*0.5);
                //System.out.println(score1.addAll());
                scoreMapper.updateEatingScore(userId,score1.getEating());
                scoreMapper.updatePoint(userId,score1.getPoint());
            }
            return "true";
        }
    }

    @Override
    public String addPlayingScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addPlayingScore(userId,score);
                scoreMapper.updatePoint(userId,200-score*0.5);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                //System.out.println(score1.addAll());
                scoreMapper.updatePlayingScore(userId,score1.getPlaying()+score);
                scoreMapper.updatePoint(userId,score1.getPoint()-score*0.5);
            }
            return "true";
        }
    }

    @Override
    public String addTrafficScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addTrafficScore(userId,score);
                scoreMapper.updatePoint(userId,200-score*0.5);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                //System.out.println(score1.addAll());
                scoreMapper.updateTrafficScore(userId,score1.getTraffic()+score);
                scoreMapper.updatePoint(userId,score1.getPoint()-score*0.5);
            }
            return "true";
        }
    }

    @Override
    public String addShoppingScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addShoppingScore(userId,score);
                scoreMapper.updatePoint(userId,200-score*0.5);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                //System.out.println(score1.addAll());
                scoreMapper.updateShoppingScore(userId,score1.getShopping()+score);
                scoreMapper.updatePoint(userId,score1.getPoint()-score*0.5);
            }
            return "true";
        }
    }

    @Override
    public String addSleepingScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addSleepingScore(userId,score);
                scoreMapper.updatePoint(userId,200-score*0.5);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                //System.out.println(score1.addAll());
                scoreMapper.updateSleepingScore(userId,score1.getSleeping()+score);
                scoreMapper.updatePoint(userId,score1.getPoint()-score*0.5);
            }
            return "true";
        }
    }

    @Override
    public String addAnsweringScore(double score, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户之前没有积分记录，创建积分记录");
                scoreMapper.addAnsweringScore(userId,score);
                scoreMapper.updatePoint(userId,200+score);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                //System.out.println(score1.addAll());
                scoreMapper.updateAnsweringScore(userId,score1.getAnswering()+score);
                scoreMapper.updatePoint(userId,score1.getPoint()+score);
            }
            return "true";
        }
    }

    @Override
    public String addMoney(double money, String userId) {
        if (userService.isExist(userId) == "false") {
            System.out.println("用户id不存在");
            return "false";
        } else {
            if (scoreMapper.queryScore(userId) == null) {
                System.out.println("用户赞助"+money);
                scoreMapper.updatePoint(userId,200+money*0.3);
            } else {
                System.out.println("用户之前存在积分记录，更新积分记录");
                Score score1 = scoreMapper.queryScore(userId);
                //System.out.println("之前的总积分" + score1.addAll());
                //System.out.println(score1.addAll());
                scoreMapper.updatePoint(userId,score1.getPoint()+money*0.3);
            }
            return "true";
        }
    }


    @Override
    public double queryScore(String id) {
        Score score = scoreMapper.queryScore(id);
        return score.getPoint();
    }

    @Override
    public Score queryUserCarbon(String userId) {
        Score score = scoreMapper.queryScore(userId);
        return score;
    }

    @Override
    public double shop(double weight, int box, int bag,int method, double distance) {
        double score=0.0;
        if(weight<1) {
            if (box >= 1 && box <= 3) {
                score += 0.0938;
            } else if (box > 3) {
                score += 0.1552;
            }
            if (bag >= 1 && bag <= 3) {
                score += 0.1102;
            } else if (bag > 3) {
                score += 0.1880;
            }
        }else if(weight>=1&&weight<3){

            if (box >= 1 && box <= 3) {
                score += 0.1424;
            } else if (box > 3) {
                score += 0.2038;
            }
            if (bag >= 1 && bag <= 3) {
                score += 0.1588;
            } else if (bag > 3) {
                score += 0.2366;
            }

        }else if(weight>=3&&weight<4){

            if (box >= 1 && box <= 3) {
                score += 0.1748;
            } else if (box > 3) {
                score += 0.2362;
            }
            if (bag >= 1 && bag <= 3) {
                score += 0.1912;
            } else if (bag > 3) {
                score += 0.2690;
            }

        }else if(weight>=4){
            if (box >= 1 && box <= 3) {
                score += 0.2072;
            } else if (box > 3) {
                score += 0.2686;
            }
            if (bag >= 1 && bag <= 3) {
                score += 0.2236;
            } else if (bag > 3) {
                score += 0.3014;
            }
        }
        if(method==1){
            score+=0.0000005*distance;
        }else if(method==2){
            score+=0.0000008*distance;
        }
        return score;
    }

    @Override
    public String buyGoods(double price, String userId) {
        Score score = scoreMapper.queryScore(userId);
        scoreMapper.updatePoint(userId,score.getPoint()-price);
        return "true";
    }


}
