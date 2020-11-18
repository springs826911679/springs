package com.springs.demo.controller;


import com.google.gson.Gson;
import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Goods;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.GoodsService;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
//    @Autowired
//    UserService userService;
//    @RequestMapping("/articles")
//    public List<ArticleDto> getAll() throws InvocationTargetException, IllegalAccessException {
//        List<Article> articles = articleService.getAll();
//        if (articles!=null){
//        return articleService.toDtos(articles);
//        }
//        return null;
//    }
    @GetMapping("/goods")
    public PageResult<Goods> getOne(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        GoodsSearchParams articleSearchParams = new GoodsSearchParams();
        BeanUtils.populate(articleSearchParams,reqMap);
        return     PageResult.wrap(goodsService.search(articleSearchParams));

    }
    @PostMapping("/goods")
    public Goods insertOne(@RequestBody String json){
        Gson gson = new Gson();
        Goods article = gson.fromJson(json, Goods.class);
        return   goodsService.save(article);
    }
    @DeleteMapping("/goods/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id) throws Exception {
        return goodsService.deleteOne(id);
    }
    @PutMapping("/goods/{id}")
    public Goods updateOne(@RequestBody HashMap<String,Object> map, @PathVariable("id") Integer id) throws InvocationTargetException, IllegalAccessException {
      return   goodsService.updateOne(id,map);
    }

    @GetMapping("/goods/{id}")
    public Goods getOne(@PathVariable("id")Integer id){
      return   goodsService.findOne(id);
    }

//    @GetMapping("/goodss")
//    public List<Goods> getAll(){
//        return   goodsService.getAll();
//    }
}
