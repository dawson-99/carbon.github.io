package com.change.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.change.pojo.User;

public interface UserService extends IService<User> {

    String isExist(String id);

    User login(String username,String password);

    User register(String username,String password);

    double queryScore(String id);
}
