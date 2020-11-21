package com.springs.demo.controller;


import com.springs.demo.domain.Goods;
import com.springs.demo.domain.GoodsEnrollment;
import com.springs.demo.domain.User;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.GoodsEnrollmentService;
import com.springs.demo.service.GoodsService;
import com.springs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/")
    public String index(Model model,@RequestParam(required = false,value = "categoryName")String categoryName){
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();
        goodsSearchParams.setCategoryName(categoryName);
        model.addAttribute("goods",goodsService.search(goodsSearchParams).getContent());
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

    @RequestMapping("/show")
    public String show(){
        return "show";
    }

    @RequestMapping("mygoods")
    public String toMyGoods(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userService.findFirstByUserByName(userDetails.getUsername());
        List<GoodsEnrollment> goodsEnrollmentList = goodsEnrollmentService.findAllByUserId(user.getId());
        List<Goods> goodss = new ArrayList<>();
        for (GoodsEnrollment goodsEnrollment:goodsEnrollmentList){
            Goods goods= goodsService.findOne(goodsEnrollment.getId());
            goodss.add(goods);
        }
        model.addAttribute("goods",goodss);
        return "myGoods";
    }

//    @RequestMapping("/addMyGoods")
//    public String addMyGoods(@RequestParam("id")Integer id){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal();
//        User user = userService.findFirstByUserByName(userDetails.getUsername());
//        GoodsEnrollment goodsEnrollment =new GoodsEnrollment();
//        goodsEnrollment.setCourseId(id);
//        goodsEnrollment.setUserId(user.getId());
//        goodsEnrollmentService.save(goodsEnrollment);
//    }


}
