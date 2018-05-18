package com.zly.controller;

import com.zly.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zly11 on 2018/4/5.
 */
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;


}
