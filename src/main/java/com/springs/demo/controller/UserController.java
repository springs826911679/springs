package com.springs.demo.controller;


import com.google.gson.Gson;
import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.User;
import com.springs.demo.dto.ThreadDto;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.search.ThreadSearchParams;
import com.springs.demo.search.UserSearchParams;
import com.springs.demo.service.GoodsService;
import com.springs.demo.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping ("/register")
    public Boolean register(@RequestBody User user) {
        if (userService.findFirstByUserByName(user.getUsername())!=null){
            return false;
        }else {
            userService.addUser(user);
            return true;
        }
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id) throws Exception {
//        goodsEnrollmentService.deleteAllByCourseId(id);
        return userService.deleteOne(id);
    }
    @RequestMapping("/login")
    public User login(@RequestBody User user){

         User user1 = userService.findFirstByUserByName(user.getUsername());
         if (user1!=null&&passwordEncoder.matches(user.getPassword(),user1.getPassword())){
             return user1;
         }else {
             return null;
         }
    }
//
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping ("/users")
    public Page<User> getAll(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        UserSearchParams userSearchParams = new UserSearchParams();
        userSearchParams.setSort("-createDate");
        BeanUtils.populate(userSearchParams,reqMap);
        return  userService.search(userSearchParams);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users")
    public User insertOne(@RequestBody  User user) throws InvocationTargetException, IllegalAccessException {
        return  userService.save(user);
    }
    @PostMapping("/usersBatch")
    public Integer deleteByIdIn(@RequestBody List<Integer> ids){
        return userService.deleteByIdIn(ids);
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable("id") Integer id){
        return userService.findOne(id);
    }

}
