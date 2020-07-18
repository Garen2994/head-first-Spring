package com.garen.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){ //Bean的名字和方法的名字一样
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
