package com.springs.demo.service;

import com.springs.demo.common.http.PageResult;
import com.springs.demo.common.search.PageSearch;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.RewardRecord;
import com.springs.demo.domain.Thread;
import com.springs.demo.domain.User;
import com.springs.demo.dto.RewardRecordDto;
import com.springs.demo.dto.ThreadDto;
import com.springs.demo.repository.GoodsRepository;
import com.springs.demo.repository.RewardRecordRepository;
import com.springs.demo.repository.UserRepository;
import com.springs.demo.search.GoodsSearchParams;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class RewardRecordService {
    @Autowired
    RewardRecordRepository rewardRecordRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    public RewardRecord save(RewardRecord article){
        return rewardRecordRepository.saveAndFlush(article);
    }
    public List<RewardRecord> getAll(){
       return rewardRecordRepository.findAll();
    }
    public PageResult<RewardRecordDto> search(GoodsSearchParams params) throws InvocationTargetException, IllegalAccessException {
        PageResult<RewardRecordDto> threadDtoPageResult = new PageResult<>();
        PageSearch<RewardRecord> search = new PageSearch<>(rewardRecordRepository,rewardRecordRepository);
        PageResult<RewardRecord> wrap = PageResult.wrap(search.search(params));
        threadDtoPageResult.setPagination(wrap.getPagination());
        List<RewardRecordDto> threadDtos = toDtos(wrap.getList());
        threadDtoPageResult.setList(threadDtos);
        return threadDtoPageResult;
    }
    public RewardRecord findOne(int id) {
//            Course model = courseRepository.findOne(id);
        Optional<RewardRecord> optional = rewardRecordRepository.findById(id);
        RewardRecord model = optional.orElse(null);
        return model;
    }
    @Transactional
    public int deleteOne(Integer id)throws Exception{
        return rewardRecordRepository.retain(id);
    }
    public RewardRecord updateOne(Integer id,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        Optional<RewardRecord> optional = rewardRecordRepository.findById(id);
        RewardRecord model = optional.orElse(null);
        if(model !=null){
            BeanUtils.populate(model,map);
            rewardRecordRepository.saveAndFlush(model);
        }
        return model;
    }
    public List<RewardRecord> findAllByCategoryName(String name){
        return rewardRecordRepository.findAllByName(name);
    }
    public User modifyUserAndAddRewardRecord(RewardRecord rewardRecord){
        Integer userId = rewardRecord.getUserId();
        User user = userRepository.findById(userId).get();
        rewardRecord.setCreateDate(new Date());
        rewardRecordRepository.saveAndFlush(rewardRecord);
        user.setCount(user.getCount()-1);
        userRepository.saveAndFlush(user);
        return user;
    }
    public RewardRecordDto toDto(RewardRecord rewardRecord) throws InvocationTargetException, IllegalAccessException {
        RewardRecordDto rewardRecordDto = new RewardRecordDto();
        BeanUtils.copyProperties(rewardRecordDto,rewardRecord);
        User one = userService.findOne(rewardRecord.getUserId());
        rewardRecordDto.setUsername(one==null?null:one.getUsername());
        return rewardRecordDto;
    }
    public List<RewardRecordDto> toDtos(List<RewardRecord> threads) throws InvocationTargetException, IllegalAccessException {
        List<RewardRecordDto> threadDtos = new ArrayList<>();
        for (RewardRecord thread:threads){
            threadDtos.add(toDto(thread));
        }
        return threadDtos;
    }
    @Transactional
    public Integer deleteByIdIn(List<Integer> ids){
        return rewardRecordRepository.deleteByIdIn(ids);
    }
    public List<RewardRecord> rewardRecordByName(String name){
        return rewardRecordRepository.findAllByName(name);
    }

}
