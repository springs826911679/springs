package com.springs.demo.service;

import com.springs.demo.common.search.PageSearch;
import com.springs.demo.domain.AwardRecord;
import com.springs.demo.domain.Goods;
import com.springs.demo.repository.AwardRecordRepository;
import com.springs.demo.repository.GoodsRepository;
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
public class AwardRecordService {
    @Autowired
    AwardRecordRepository awardRecordRepository;


    public AwardRecord save(AwardRecord awardRecord){
        return awardRecordRepository.saveAndFlush(awardRecord);
    }
    public List<AwardRecord> getAll(){
       return awardRecordRepository.findAll();
    }
    public Page<AwardRecord> search(GoodsSearchParams params){
        PageSearch<AwardRecord> search = new PageSearch<>(awardRecordRepository,awardRecordRepository);
        return search.search(params);
    }
    public AwardRecord findOne(int id) {
//            Course model = courseRepository.findOne(id);
        Optional<AwardRecord> optional = awardRecordRepository.findById(id);
        AwardRecord model = optional.orElse(null);
        return model;
    }
    @Transactional
    public int deleteOne(Integer id)throws Exception{
        return awardRecordRepository.retain(id);
    }
    public AwardRecord updateOne(Integer id,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        Optional<AwardRecord> optional = awardRecordRepository.findById(id);
        AwardRecord model = optional.orElse(null);
        if(model !=null){
            BeanUtils.populate(model,map);
            awardRecordRepository.saveAndFlush(model);
        }
        return model;
    }
    public List<AwardRecord> findAllByUserId(Integer userId){
        return awardRecordRepository.findAllByUserId(userId);
    }
}
