package com.springs.demo.service;

import com.springs.demo.common.search.PageSearch;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.GoodsEnrollment;
import com.springs.demo.repository.GoodsEnrollmentRepository;
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
public class GoodsEnrollmentService {
    @Autowired
    GoodsEnrollmentRepository goodsEnrollmentRepository;


    public GoodsEnrollment save(GoodsEnrollment article){
        return goodsEnrollmentRepository.saveAndFlush(article);
    }
    public List<GoodsEnrollment> getAll(){
       return goodsEnrollmentRepository.findAll();
    }
    public Page<GoodsEnrollment> search(GoodsSearchParams params){
        PageSearch<GoodsEnrollment> search = new PageSearch<>(goodsEnrollmentRepository,goodsEnrollmentRepository);
        return search.search(params);
    }
    public GoodsEnrollment findOne(int id) {
//            Course model = courseRepository.findOne(id);
        Optional<GoodsEnrollment> optional = goodsEnrollmentRepository.findById(id);
        GoodsEnrollment model = optional.orElse(null);
        return model;
    }
    @Transactional
    public int deleteOne(Integer id)throws Exception{
        return goodsEnrollmentRepository.retain(id);
    }
    public List<GoodsEnrollment> findAllByUserId(Integer id){
        return goodsEnrollmentRepository.findAllByUserId(id);
    }

    @Transactional
    public Integer deleteAllByCourseIdAndUserId(Integer courseId,Integer userId){
      return   goodsEnrollmentRepository.deleteAllByCourseIdAndUserId(courseId,userId);
    }
    public GoodsEnrollment findFirstByCourseIdAndUserId(Integer courseId,Integer userId){
        return   goodsEnrollmentRepository.findFirstByCourseIdAndUserId(courseId,userId);
    }
}
