package com.springs.demo.common.security;

import com.springs.demo.service.UserDetailsServiceImpl;
import com.springs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("admin","user")//指定角色
                                .antMatchers("/add").hasAnyRole("admin")
                                .antMatchers("/mygoods").hasAnyRole("admin","user")
                                .antMatchers("/api").permitAll()
                                .antMatchers("/show").hasAnyRole("admin")
                                .antMatchers("/register").permitAll()
                                .antMatchers("/login").permitAll();
        http.formLogin().loginPage("/login").loginProcessingUrl("/toLogin").defaultSuccessUrl("/");//指定登录页面
        http.logout();
        http.csrf().disable();
    }



    //密码加密
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
