package com.springs.demo.repository;

import com.springs.demo.domain.Goods;
import com.springs.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.IdentityHashMap;


public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
    @Modifying
    @Query("delete from User where id=:id")
    int retain(@Param("id") Integer id);

//    @Query("update Article set categoryId=null where categoryId=:categoryId")
//    int resetCategory(@Param("categoryId") Integer categoryId);
//
//    List<Goods> findAllByCategoryId(Integer categoryId);
    User findFirstByUsername(String name);

}
