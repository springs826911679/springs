package com.springs.demo.repository;

import com.springs.demo.domain.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ThreadRepository extends JpaRepository<Thread, Integer>,JpaSpecificationExecutor<Thread> {

//    @Modifying
//    @Query("delete from Thread where id=:id")
//    int retain(@Param("id") Integer id);
    @Query("update Thread set categoryId=null where categoryId=:categoryId")
    int resetCategory(@Param("categoryId") Integer categoryId);








    }

