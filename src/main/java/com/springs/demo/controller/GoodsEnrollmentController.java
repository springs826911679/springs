package com.springs.demo.controller;


import com.google.gson.Gson;
import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.GoodsEnrollment;
import com.springs.demo.domain.User;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.GoodsEnrollmentService;
import com.springs.demo.service.GoodsService;
import com.springs.demo.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GoodsEnrollmentController {

    @Autowired
    GoodsEnrollmentService goodsEnrollmentService;
    @Autowired
    UserService userService;

    @GetMapping("/goods-enrollment")
    public PageResult<GoodsEnrollment> getOne(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        GoodsSearchParams articleSearchParams = new GoodsSearchParams();
        BeanUtils.populate(articleSearchParams,reqMap);
        return     PageResult.wrap(goodsEnrollmentService.search(articleSearchParams));

    }
    @PostMapping("/goods-enrollment")
    public GoodsEnrollment insertOne(@RequestParam("id")Integer id){
            User user = userService.getCurrentUser();
        GoodsEnrollment goodsEnrollment = goodsEnrollmentService.findFirstByCourseIdAndUserId(id, user.getId());
        if (goodsEnrollment!=null){
            return goodsEnrollmentService.save(goodsEnrollment);
        }else {
            goodsEnrollment =new GoodsEnrollment();
            goodsEnrollment.setCourseId(id);
            goodsEnrollment.setUserId(user.getId());
            return goodsEnrollmentService.save(goodsEnrollment);
        }

    }
    @DeleteMapping("/goods-enrollment/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id) throws Exception {
        User currentUser = userService.getCurrentUser();
        return goodsEnrollmentService.deleteAllByCourseIdAndUserId(id,currentUser.getId());
    }

    @GetMapping("/goods-enrollment/{id}")
    public GoodsEnrollment getOne(@PathVariable("id")Integer id){
      return   goodsEnrollmentService.findOne(id);
    }



}
