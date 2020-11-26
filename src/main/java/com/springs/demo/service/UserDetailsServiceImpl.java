package com.springs.demo.service;


import com.springs.demo.common.security.UserDetail;
import com.springs.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

            return   new UserDetail(user.getId().toString(),user.getUsername(), user.getPassword(), mapToGrantedAuthorities(user.getRoles()));

        }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<String> roles) {
        return roles.stream()
                .map(s->"ROLE_"+s)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


}
