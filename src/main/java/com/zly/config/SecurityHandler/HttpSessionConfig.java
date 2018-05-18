package com.zly.config.SecurityHandler;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by zly11 on 2018/4/24.
 */

@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
}
