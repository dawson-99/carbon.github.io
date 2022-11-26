package com.change.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.change.mapper.ScoreMapper;
import com.change.mapper.UserMapper;
import com.change.pojo.User;
import com.change.service.UserService;
import com.change.utils.IDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public String isExist(String id) {
        User user = userMapper.queryUserById(id);
        if(user!=null){
            return "true";
        }
        return "false";
    }

    @Override
    public User login(String username, String password) {
        User user=userMapper.queryUser(username,password);
        if(user!=null){
            return user;
        }
        return null;
    }

    @Override
    public User register(String username, String password) {
        User haveUser = userMapper.queryUser(username, password);
        if(haveUser!=null){
            return null;
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setId(IDutils.getId());
        int i=userMapper.addUser(user);
        if(i!=1){
            return null;
        }
        //System.out.println(i);
        return user;
    }

    @Override
    public double queryScore(String id) {
       // System.out.println(scoreMapper.queryScore(id));
        if (scoreMapper.queryScore(id)==null){
            return 200;
        }
        return scoreMapper.queryScore(id).getPoint();
    }
}
