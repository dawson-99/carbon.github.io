package com.change.controller;

import com.change.pojo.User;
import com.change.service.UserService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("小程序调用接口(登录)  用户名:"+username+" 密码:"+password);
        User user = userService.login(username, password);
        user.setScore(userService.queryScore(user.getId()));
        if (user!=null){
            return user;
        }
        return new User("0001");
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("小程序调用接口(注册)  用户名:" + username + " 密码:" + password);
        User register = userService.register(username, password);
        if (register != null) {
            if (register.getId() != null) {
                return register.getId();
            }
        }
        return "false";
    }
    @PostMapping("/refresh")
    public double refresh(@RequestParam("userId") String id){
        return userService.queryScore(id);
    }
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
