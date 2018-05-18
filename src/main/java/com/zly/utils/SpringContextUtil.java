package com.zly.utils;

import org.springframework.context.ApplicationContext;

/**
 * Created by zly11 on 2018/4/24.
 */
public class SpringContextUtil {

    private static ApplicationContext applicationContext = null;

    public   static ApplicationContext getApplication(){
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }



}
