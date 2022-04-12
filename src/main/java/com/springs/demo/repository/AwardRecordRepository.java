package com.springs.demo.repository;

import com.springs.demo.domain.AwardRecord;
import com.springs.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AwardRecordRepository extends JpaRepository<AwardRecord, Integer>,JpaSpecificationExecutor<User> {
    @Modifying
    @Query("delete from AwardRecord where id=:id")
    int retain(@Param("id") Integer id);

//    @Query("update Article set categoryId=null where categoryId=:categoryId")
//    int resetCategory(@Param("categoryId") Integer categoryId);
//
//    List<Goods> findAllByCategoryId(Integer categoryId);
    List<AwardRecord> findAllByUserId(Integer userId);

}
