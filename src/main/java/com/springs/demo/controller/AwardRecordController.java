package com.springs.demo.controller;


import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.AwardRecord;
import com.springs.demo.domain.Goods;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.AwardRecordService;
import com.springs.demo.service.GoodsEnrollmentService;
import com.springs.demo.service.GoodsService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AwardRecordController {

    @Autowired
    AwardRecordService awardRecordService;

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
    @GetMapping("/awardRecord")
    public PageResult<AwardRecord> getOne(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        GoodsSearchParams articleSearchParams = new GoodsSearchParams();
        BeanUtils.populate(articleSearchParams,reqMap);
        return     PageResult.wrap(awardRecordService.search(articleSearchParams));

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/awardRecord")
    public AwardRecord insertOne(@RequestBody  HashMap<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        AwardRecord goods = new AwardRecord();
        BeanUtils.populate(goods,map);
        return   awardRecordService.save(goods);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/awardRecord/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id) throws Exception {
        return awardRecordService.deleteOne(id);
    }


    @GetMapping("/awardRecord/{id}")
    public AwardRecord getOne(@PathVariable("id")Integer id){
      return   awardRecordService.findOne(id);
    }

//    @GetMapping("/goodss")
//    public List<Goods> getAll(){
//        return   goodsService.getAll();
//    }
}
