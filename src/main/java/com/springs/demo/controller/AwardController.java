package com.springs.demo.controller;


import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Award;
import com.springs.demo.domain.AwardRecord;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.AwardRecordService;
import com.springs.demo.service.AwardService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AwardController {

    @Autowired
    AwardService awardService;

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
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/award")
    public PageResult<Award> getOne(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        GoodsSearchParams articleSearchParams = new GoodsSearchParams();
        BeanUtils.populate(articleSearchParams,reqMap);
        return     PageResult.wrap(awardService.search(articleSearchParams));

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/award")
    public Award insertOne(@RequestBody  HashMap<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        Award goods = new Award();
        BeanUtils.populate(goods,map);
        return   awardService.save(goods);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/award/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id) throws Exception {
        return awardService.deleteOne(id);
    }


    @GetMapping("/award/{id}")
    public Award getOne(@PathVariable("id")Integer id){
      return   awardService.findOne(id);
    }

//    @GetMapping("/goodss")
//    public List<Goods> getAll(){
//        return   goodsService.getAll();
//    }
}
