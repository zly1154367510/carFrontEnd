package com.zly.service.impl;

import com.sun.xml.internal.ws.api.FeatureConstructor;
import com.zly.pojo.TokenModel;
import com.zly.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.security.pkcs11.wrapper.Constants;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by zly11 on 2018/4/5.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public String selectAuthCode(String uuid) {
        String token1 = redisTemplate.opsForValue().get(uuid);
        return token1;
    }

    @Override
    public String createAuthCode(String authCodeKey,String authCode) {

        redisTemplate.opsForValue().set(authCodeKey,authCode,1,TimeUnit.MINUTES);
        return null;
    }

    @Override
    public String createToken(String username) {

        String uuid = UUID.randomUUID().toString().replace("-","");
        redisTemplate.opsForValue().set(username,uuid,20,TimeUnit.MINUTES);
        return uuid;
    }

    @Override
    public String selectToken(String username) {
        String token1 = redisTemplate.opsForValue().get(username);
        return token1;
    }

    @Override
    public void deleteToken(String username) {
        redisTemplate.opsForValue().getOperations().delete(username);
        redisTemplate.delete(username);
    }
}
