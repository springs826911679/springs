package com.springs.demo.service;

import com.springs.demo.common.search.PageSearch;
import com.springs.demo.common.security.UserDetail;
import com.springs.demo.domain.Goods;
import com.springs.demo.domain.User;
import com.springs.demo.repository.GoodsRepository;
import com.springs.demo.repository.UserRepository;
import com.springs.demo.search.GoodsSearchParams;
import com.springs.demo.search.UserSearchParams;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User article){
        return userRepository.saveAndFlush(article);
    }

    public List<User> getAll(){
       return userRepository.findAll();
    }
    public Page<User> search(UserSearchParams params){
        PageSearch<User> search = new PageSearch<>(userRepository,userRepository);
        return search.search(params);
    }
    public User findOne(int id) {
//            Course model = courseRepository.findOne(id);
        Optional<User> optional = userRepository.findById(id);
        User model = optional.orElse(null);
        return model;
    }
    @Transactional
    public int deleteOne(Integer id)throws Exception{
        return userRepository.retain(id);
    }
    public User updateOne(Integer id,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        Optional<User> optional = userRepository.findById(id);
        User model = optional.orElse(null);
        if(model !=null){
            BeanUtils.populate(model,map);
            userRepository.saveAndFlush(model);
        }
        return model;
    }
    public User addUser(User user) {
        if (user.getUsername() != null && user.getPassword() != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        else
            user = null;
        return user;
    }
    public User findFirstByUserByName(String name){
      return   userRepository.findFirstByUsername(name);
    }

    public User getCurrentUser(){
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
      return  findOne(Integer.parseInt(userDetail.getId()));
    }

    @Transactional
    public Integer deleteByIdIn(List<Integer> ids){
        return userRepository.deleteByIdIn(ids);
    }

}
