package com.springs.demo.service;


import com.springs.demo.common.http.PageResult;
import com.springs.demo.common.search.PageSearch;
import com.springs.demo.domain.User;
import com.springs.demo.dto.ThreadDto;
import com.springs.demo.repository.ThreadRepository;
import com.springs.demo.search.ThreadSearchParams;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.springs.demo.domain.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ThreadService {

    @Autowired
   private ThreadRepository threadRepository;
    @Autowired
    private UserService userService;






    public PageResult<ThreadDto> search(ThreadSearchParams threadSearchParams) throws InvocationTargetException, IllegalAccessException {
        PageResult<ThreadDto> threadDtoPageResult = new PageResult<>();
        PageSearch<Thread> search = new PageSearch<>(threadRepository,threadRepository);
        PageResult<Thread> wrap = PageResult.wrap(search.search(threadSearchParams));
        threadDtoPageResult.setPagination(wrap.getPagination());
        List<ThreadDto> threadDtos = toDtos(wrap.getList());
        threadDtoPageResult.setList(threadDtos);
        return threadDtoPageResult;
    }
    public Thread save(Thread thread){
        return threadRepository.save(thread);
    }
    public Thread update(HashMap<String,Object> map,Integer id) throws InvocationTargetException, IllegalAccessException {
        Optional<Thread> optional = threadRepository.findById(id);
        Thread model = optional.orElse(null);
        if(model !=null){
            BeanUtils.populate(model,map);
            threadRepository.saveAndFlush(model);
        }
        return model;
    }
    public void deleteOne(Integer id){
         threadRepository.deleteById(id);
    }


    public Thread findOne(Integer id){
        return threadRepository.findById(id).get();
    }

    public ThreadDto toDto(Thread thread) throws InvocationTargetException, IllegalAccessException {
        User currentUser = userService.getCurrentUser();
        ThreadDto threadDto = new ThreadDto();
        BeanUtils.copyProperties(threadDto,thread);
        User one = userService.findOne(thread.getUserId());
        threadDto.setUserName(one==null?null:one.getUsername());
        return threadDto;
    }
    public List<ThreadDto> toDtos(List<Thread> threads) throws InvocationTargetException, IllegalAccessException {
        List<ThreadDto> threadDtos = new ArrayList<>();
        for (Thread thread:threads){
            threadDtos.add(toDto(thread));
        }
        return threadDtos;
    }

    }



