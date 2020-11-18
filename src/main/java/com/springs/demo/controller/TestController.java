package com.springs.demo.controller;


import com.springs.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    GoodsService goodsService;
    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }
}
