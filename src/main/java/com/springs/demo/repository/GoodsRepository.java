package com.springs.demo.repository;

import com.springs.demo.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GoodsRepository extends JpaRepository<Goods, Integer>,JpaSpecificationExecutor<Goods> {
    @Modifying
    @Query("delete from Goods where id=:id")
    int retain(@Param("id") Integer id);

    List<Goods> findAllByCategoryName(String name);

//    @Query("update Article set categoryId=null where categoryId=:categoryId")
//    int resetCategory(@Param("categoryId") Integer categoryId);
//
//    List<Goods> findAllByCategoryId(Integer categoryId);

}
