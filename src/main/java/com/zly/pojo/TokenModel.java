package com.zly.pojo;

/**
 * Created by zly11 on 2018/4/5.
 */
public class TokenModel {

    private String username;
    private String token;

    public TokenModel(String username,String token){
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUuid() {
        return token;
    }

    public void setUuid(String uuid) {
        this.token = uuid;
    }
}
