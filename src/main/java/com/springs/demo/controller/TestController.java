package com.springs.demo.controller;


import com.springs.demo.service.GoodsService;
import com.springs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserService userService;
    @RequestMapping("/index")
    public String test(){

        System.out.println(userService.getCurrentUser());
        return "index";
    }
}
