package com.zly.service.impl;

import com.zly.mapper.UserMapper;
import com.zly.pojo.User;
import com.zly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zly11 on 2018/4/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User loginUser(String username,String password) {
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return userMapper.loginUser(map);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User register(User user) {
        return userMapper.register(user);
    }
}
