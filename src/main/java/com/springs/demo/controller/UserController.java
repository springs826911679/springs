package com.springs.demo.controller;


import com.google.gson.Gson;
import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.User;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.GoodsService;
import com.springs.demo.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping ("/register")
    public String register(User user) {
        userService.addUser(user);
        return user == null ? "注册失败" : "注册成功";
    }
//    @RequestMapping("/login")
//    public Boolean login(@RequestBody User user){
//
//         User user1 = userService.findFirstByUserByName(user.getUsername());
//         return user1!=null&&user1.getPassword().equals(user.getPassword());
//    }
//
//    @GetMapping ("/users")
//    public List<User> getAll(){
//       return userService.getAll();
//    }
}
