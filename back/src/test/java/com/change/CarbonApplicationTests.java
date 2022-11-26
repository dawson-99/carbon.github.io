package com.change;

import com.change.mapper.ScoreMapper;
import com.change.pojo.User;
import com.change.service.GoodsService;
import com.change.service.ScoreService;
import com.change.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarbonApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    ScoreService scoreService;
    @Autowired
    GoodsService goodsService;

    @Test
    void register() {
        User hello = userService.register("hello", "666");
        System.out.println(hello);
    }

    @Test
    public User login(){
        User login = userService.login("hello", "666");
        return login;
    }

    @Test
    public void queryScore(){
       // System.out.println(userService.queryScore(login().getId()));
        System.out.println(scoreMapper.queryScore(userService.login("hello", "666").getId()));
    }

    @Test
    public void addScore(){
        String s = scoreService.addTransportationScore(100, "1001");
        System.out.println(s);
    }

    @Test
    public void queryAllGoods(){
        System.out.println(goodsService.queryAllGoods());
    }


}
