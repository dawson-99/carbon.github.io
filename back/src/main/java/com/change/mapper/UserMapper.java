package com.change.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.change.pojo.User;


public interface UserMapper extends BaseMapper<User> {

    User queryUser(String username,String password);

    User queryUserById(String id);

    int addUser(User user);
}
