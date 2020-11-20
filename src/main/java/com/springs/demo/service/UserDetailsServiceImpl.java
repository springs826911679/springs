package com.springs.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.springs.demo.domain.User user = userService.findFirstByUserByName(s);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new User(s, user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
