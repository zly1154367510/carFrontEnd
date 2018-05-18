package com.zly.service;

import com.zly.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/4/3.
 */

public interface UserService {

    User loginUser(String username,String password);
    List<User> findAllUser();
    User register(User user);

}
