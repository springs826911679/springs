package com.springs.demo.service;

import com.springs.demo.common.search.PageSearch;
import com.springs.demo.domain.Award;
import com.springs.demo.domain.AwardRecord;
import com.springs.demo.repository.AwardRecordRepository;
import com.springs.demo.repository.AwardRepository;
import com.springs.demo.search.GoodsSearchParams;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AwardService {
    @Autowired
    AwardRepository awardRepository;


    public Award save(Award award){
        return awardRepository.saveAndFlush(award);
    }
    public List<Award> getAll(){
       return awardRepository.findAll();
    }
    public Page<Award> search(GoodsSearchParams params){
        PageSearch<Award> search = new PageSearch<>(awardRepository,awardRepository);
        return search.search(params);
    }
    public Award findOne(int id) {
//            Course model = courseRepository.findOne(id);
        Optional<Award> optional = awardRepository.findById(id);
        Award model = optional.orElse(null);
        return model;
    }
    @Transactional
    public int deleteOne(Integer id)throws Exception{
        return awardRepository.retain(id);
    }
    public Award updateOne(Integer id,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        Optional<Award> optional = awardRepository.findById(id);
        Award model = optional.orElse(null);
        if(model !=null){
            BeanUtils.populate(model,map);
            awardRepository.saveAndFlush(model);
        }
        return model;
    }
    public List<Award> findAllByUserId(Integer userId){
        return awardRepository.findAllByAwardName(userId);
    }
}
