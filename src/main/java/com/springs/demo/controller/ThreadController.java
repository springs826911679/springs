package com.springs.demo.controller;

import com.springs.demo.common.http.PageResult;
import com.springs.demo.domain.Thread;
import com.springs.demo.domain.User;
import com.springs.demo.dto.ThreadDto;
import com.springs.demo.search.ThreadSearchParams;
import com.springs.demo.service.ThreadService;
import com.springs.demo.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ThreadController {

    @Autowired
    ThreadService threadService;
    @Autowired
    UserService userService;
    @GetMapping("/threads")
    public PageResult<ThreadDto> getAll(@RequestParam(required = false) Map<String,Object> reqMap) throws InvocationTargetException, IllegalAccessException {
        ThreadSearchParams threadSearchParams = new ThreadSearchParams();
        BeanUtils.populate(threadSearchParams,reqMap);
        return  threadService.search(threadSearchParams);
    }
    @PostMapping("/threads")
    public Thread insertOne(@RequestBody Thread thread){
        User currentUser = userService.getCurrentUser();
        thread.setUserId(currentUser.getId());
        return threadService.save(thread);
    }

    @DeleteMapping("/threads/{id}")
    public void deleteOne(@PathVariable("id") Integer id){
        threadService.deleteOne(id);
    }



}
