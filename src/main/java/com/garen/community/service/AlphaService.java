package com.garen.community.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    public AlphaService() {
        System.out.println("Instantiate AlphaService");
    }
    @PostConstruct
    public void init(){
        System.out.println("Initialize AlphaService");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy AlphaService");
    }
}
