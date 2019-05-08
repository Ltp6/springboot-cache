package com.ltp.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;
/*
* 自定义缓存key生成策略
* */
@Configuration
public class SelfKeyGenerator {

    @Bean(value = "keyGeneratorMethod")
    public KeyGenerator keyGeneratorMethod(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+ Arrays.asList(params);
            }
        };
    }
}
