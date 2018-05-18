package com.zly.service;

/**
 * Created by zly11 on 2018/4/5.
 */
public interface TokenService {

    public String createToken(String username);
    public String selectToken(String username);
    public void deleteToken(String username);
    public String createAuthCode(String authCodeKey, String username);
    public String selectAuthCode(String username);
   // public void deleteToken(String username);

}
