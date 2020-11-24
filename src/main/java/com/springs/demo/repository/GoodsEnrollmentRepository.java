package com.springs.demo.repository;

import com.springs.demo.domain.GoodsEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GoodsEnrollmentRepository extends JpaRepository<GoodsEnrollment, Integer>,JpaSpecificationExecutor<GoodsEnrollment> {
    @Modifying
    @Query("delete from GoodsEnrollment where id=:id")
    int retain(@Param("id") Integer id);


    List<GoodsEnrollment> findAllByUserId(Integer id);

    Integer deleteAllByCourseIdAndUserId(Integer courseId,Integer userId);

    GoodsEnrollment findFirstByCourseIdAndUserId(Integer courseId,Integer userId);

    Integer deleteAllByCourseId(Integer courseId);
//    @Query("update Article set categoryId=null where categoryId=:categoryId")
//    int resetCategory(@Param("categoryId") Integer categoryId);
//
//    List<Goods> findAllByCategoryId(Integer categoryId);

}
