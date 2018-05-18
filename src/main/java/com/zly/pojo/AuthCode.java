package com.zly.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.SimpleBeanInfo;

/**
 * Created by zly11 on 2018/4/24.
 */

@Component ("AuthCode")
public class AuthCode {
    private String AuthCodeKey;
    private String AuthCode;

    public AuthCode(){

    }

    public AuthCode(String AuthCodeKey,String AuthCode){
        this.AuthCode = AuthCode;
        this.AuthCodeKey = AuthCodeKey;
    }

    public String getAuthCodeKey() {
        return AuthCodeKey;
    }

    public void setAuthCodeKey(String authCodeKey) {
        AuthCodeKey = authCodeKey;
    }

    public String getAuthCode() {
        return AuthCode;
    }

    public void setAuthCode(String authCode) {
        AuthCode = authCode;
    }
}