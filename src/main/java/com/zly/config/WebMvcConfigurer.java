package com.zly.config;


import com.zly.controller.interceptor.OneInterceptor;
import com.zly.controller.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zly11 on 2018/4/2.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public OneInterceptor getOnInterceptor(){
        return new OneInterceptor();
    }
    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return new RequestInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(getRequestInterceptor()).addPathPatterns("/*/**");
        registry.addInterceptor(getOnInterceptor()).addPathPatterns("/mi/**");


    }
}
