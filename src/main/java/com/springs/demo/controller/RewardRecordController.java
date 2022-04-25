package com.springs.demo.controller;


import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.RewardRecord;
import com.springs.demo.domain.User;
import com.springs.demo.dto.RewardRecordDto;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.service.GoodsEnrollmentService;
import com.springs.demo.service.GoodsService;
import com.springs.demo.service.RewardRecordService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RewardRecordController {


    @Autowired
    RewardRecordService rewardRecordService;
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
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/rewardRecord")
    public PageResult<RewardRecordDto> getOne(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        GoodsSearchParams articleSearchParams = new GoodsSearchParams();
        BeanUtils.populate(articleSearchParams,reqMap);
        return     rewardRecordService.search(articleSearchParams);

    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/rewardRecord")
    public RewardRecord insertOne(@RequestBody  HashMap<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        RewardRecord goods = new RewardRecord();
        BeanUtils.populate(goods,map);
        return   rewardRecordService.save(goods);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/rewardRecord/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id) throws Exception {
        return rewardRecordService.deleteOne(id);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/rewardRecord/{id}")
    public RewardRecord updateOne(@RequestBody HashMap<String,Object> map, @PathVariable("id") Integer id) throws InvocationTargetException, IllegalAccessException {
      return   rewardRecordService.updateOne(id,map);
    }

//    @GetMapping("/rewardRecord/{id}")
    public RewardRecord getOne(@PathVariable("id")Integer id){
      return   rewardRecordService.findOne(id);
    }

//    @GetMapping("/goodss")
//    public List<Goods> getAll(){
//        return   goodsService.getAll();
//    }
    @PostMapping("/rewardRecordModify")
    public User modifyUserAndAddRewardRecord(@RequestBody RewardRecord rewardRecord){
        return rewardRecordService.modifyUserAndAddRewardRecord(rewardRecord);
    }

    @PostMapping("/rewardRecordBatch")
    public Integer deleteByIdIn(@RequestBody List<Integer> ids){
        return rewardRecordService.deleteByIdIn(ids);
    }
    @GetMapping("/rewardRecordByName")
    public PageResult<RewardRecordDto> rewardRecordByName(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        GoodsSearchParams articleSearchParams = new GoodsSearchParams();
        BeanUtils.populate(articleSearchParams,reqMap);
        return rewardRecordService.search(articleSearchParams);
    }
}
