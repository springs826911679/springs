package com.springs.demo.controller;


import com.springs.demo.domain.Goods;
import com.springs.demo.domain.GoodsEnrollment;
import com.springs.demo.domain.User;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.search.ThreadSearchParams;
import com.springs.demo.service.GoodsEnrollmentService;
import com.springs.demo.service.GoodsService;
import com.springs.demo.service.ThreadService;
import com.springs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserService userService;
    @Autowired
    GoodsEnrollmentService goodsEnrollmentService;
    @Autowired
    ThreadService threadService;

    @RequestMapping("/")
    public String index(Model model,@RequestParam(required = false,value = "categoryName")String categoryName){
        User user = userService.getCurrentUser();
        List<Goods> all=null;
        if (categoryName==null){
            all = goodsService.getAll();
        }else {
            all= goodsService.findAllByCategoryName(categoryName);
        }
        model.addAttribute("goods",all);
        model.addAttribute("user",user);
        // System.out.println(userService.getCurrentUser());
        return "show";
    }
    @RequestMapping("/login")
    public String test(){
       // System.out.println(userService.getCurrentUser());
        return "login";
    }
    @RequestMapping("/register")
    public String register(){
        // System.out.println(userService.getCurrentUser());
        return "register";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

//    @RequestMapping("/show")
//    public String show(){
//        return "show";
//    }

    @RequestMapping("/mygoods")
    public String toMyGoods(Model model){
        User user = userService.getCurrentUser();
        List<GoodsEnrollment> goodsEnrollmentList = goodsEnrollmentService.findAllByUserId(user.getId());
        List<Goods> goodss = new ArrayList<>();
        for (GoodsEnrollment goodsEnrollment:goodsEnrollmentList){
            Goods goods= goodsService.findOne(goodsEnrollment.getCourseId());
            goodss.add(goods);
        }
        model.addAttribute("goods",goodss);
        model.addAttribute("user",user);
        return "myGoods";
    }
    @RequestMapping("/video/{id}")
    public String toMyGoods(Model model, @PathVariable("id") Integer id) throws InvocationTargetException, IllegalAccessException {
        Goods goods= goodsService.findOne(id);
        ThreadSearchParams threadSearchParams = new ThreadSearchParams();
        threadSearchParams.setGoodsId(id);
        model.addAttribute("goods",goods);
        model.addAttribute("threads",threadService.search(threadSearchParams));
        model.addAttribute("user",userService.getCurrentUser());
        return "video";
    }




}
