package com.zoie.example.controller;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/test")
public class Test {


    public static void main(String[] args) {

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println("有点过分哟");
    }
    @RequestMapping("/test1")
    public void test(){
        System.out.println("有点过分哟");
    }
}
