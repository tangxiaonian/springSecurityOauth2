package com.tang.spring.auth.component;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Classname MyUserDeatilService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 9:45
 * @Created by ASUS
 */
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Resource
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println( "==========登录验证==============" );

        if ("tang".equals(username)) {
            return User.builder()
                    .username("tang")
                    .password(bCryptPasswordEncoder.encode("123"))
                    .authorities("ROLE_USER").build();
        }
        return User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder.encode("123"))
                .authorities("ROLE_ADMIN").build();
    }
}