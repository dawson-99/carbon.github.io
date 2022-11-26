package com.change.controller;

import com.change.mapper.ScoreMapper;
import com.change.pojo.Score;
import com.change.service.ScoreService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/transportation")
    public Map<String,Object> getTransportation(@RequestParam("distance") int distance,@RequestParam("method") int method){
        Map<String,Object> map=new HashMap<>();
        double score = 0;
        String status="true";
        //System.out.println(distance);
        //System.out.println(method);
        switch (method){
            case 1:score=0.13*distance;break;
            case 2:score=0.089*distance;break;
            case 3:score=0.086*distance;break;
            case 4:score=0.075*distance;break;
            default:status="false";
        }
        map.put("status",status);
        map.put("data",score);
        return map;
    }

    @PostMapping("/addTransportationScore")
    public Map<String,Object> addScore(@RequestParam("score") double score,@RequestParam("userId")String userId){
        System.out.println(score+userId);
        Map<String,Object> map=new HashMap<>();
        String info = scoreService.addTransportationScore(score, userId);
        map.put("data",info);
        return map;
    }

    @PostMapping("/area/food")
    public Map<String,Object> addFood(@RequestParam("ratio")double ratio,@RequestParam("amount") double amount,@RequestParam("userId") String userId){
        Map<String,Object> map=new HashMap<>();
       // System.out.println(ratio+amount+userId);
        String info=scoreService.addFoodScore(ratio*amount,userId);
        map.put("info",info);
        return map;
    }

    @PostMapping("/area/playing")
    public Map<String,Object> addPlaying(@RequestParam("ratio")double ratio,@RequestParam("amount") double amount,@RequestParam("userId") String userId){
        Map<String,Object> map=new HashMap<>();
        //System.out.println(ratio+amount+userId);
        String info=scoreService.addPlayingScore(ratio*amount,userId);
        map.put("info",info);
        return map;
    }

    @PostMapping("/area/traffic")
    public Map<String,Object> addTraffic(@RequestParam("ratio")double ratio,@RequestParam("distance") double distance,@RequestParam("userId") String userId){
        Map<String,Object> map=new HashMap<>();
        System.out.println(ratio+distance+userId);
        String info=scoreService.addTrafficScore(ratio*distance,userId);
        map.put("info",info);
        return map;
    }

    @PostMapping("/area/shop")
    public Map<String,Object> addShop(@RequestParam("weight")double weight,@RequestParam("box") int box,@RequestParam("bag") int bag,
                                      @RequestParam("method")int method, @RequestParam("distance")double distance, @RequestParam("userId") String userId){
        Map<String,Object> map=new HashMap<>();
        double score=scoreService.shop(weight, box, bag,method, distance);
        String info = scoreService.addShoppingScore(score, userId);
        map.put("info",info);
        return map;
    }

    @PostMapping("/area/sleeping")
    public Map<String,Object> addTraffic(@RequestParam("ratio")double ratio,@RequestParam("day") int day,@RequestParam("userId") String userId){
        Map<String,Object> map=new HashMap<>();
        System.out.println(ratio+day);
        String info=scoreService.addSleepingScore(ratio*day,userId);
        map.put("info",info);
        return map;
    }

    @PostMapping("/question")
    public Map<String,Object> addQuestion(@RequestParam("userId") String userId,@RequestParam("score")double score){
        Map<String,Object> map=new HashMap<>();
        String info = scoreService.addAnsweringScore(score, userId);
        map.put("info",info);
        return map;
    }



    @PostMapping("/queryUserCarbon")
    public Map<String,Object> queryAll(@RequestParam("userId")String userId){
        Score score = scoreService.queryUserCarbon(userId);
        Map<String,Object> map=new HashMap<>();
        map.put("score",score);
        map.put("total",score.addAll());
        return map;
    }


    @PostMapping("/addScore")
    public Map<String,Object> addMoney(@RequestParam("userId")String userId,@RequestParam("money") double money){
        Map<String,Object> map=new HashMap<>();
        String info = scoreService.addMoney(money, userId);
        map.put("info",info);
        return map;
    }

    @PostMapping("/buyGoods")
    public Map<String,Object> buyGoods(@RequestParam("score") double price,@RequestParam("userId")String userId){
        Score score = scoreService.queryUserCarbon(userId);
        System.out.println(score);
        Map<String,Object> map=new HashMap<>();
        if(score==null){
            map.put("info","1111");
            return map;
        }if(score.getPoint()<price){
            map.put("info","0003");
            return map;
        }
        else if(score.getTraffic()==0||score.getEating()==0||score.getShopping()==0||score.getSleeping()==0||score.getPlaying()==0){
            map.put("info","0002");
            return map;
        }else if(score.getTransportation()==0){
//            map.put("info","0001");
            map.put("info",scoreService.buyGoods(price, userId));
            return map;
        }
        String info = scoreService.buyGoods(price, userId);
        map.put("info",info);
        return map;
    }

}
