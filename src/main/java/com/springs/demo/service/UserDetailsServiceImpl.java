package com.springs.demo.service;


import com.springs.demo.common.security.UserDetail;
import com.springs.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
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
        User user = userService.findFirstByUserByName(s);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if (user.getUsername().equals("admin")){
            return   new UserDetail(user.getId().toString(),user.getUsername(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin"));
        }else {
            return   new UserDetail(user.getId().toString(),user.getUsername(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_user"));
        }

    }
}
