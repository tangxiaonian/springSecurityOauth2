package com.tang.user.config;

import com.tang.user.component.MyAccessDeniedHandler;
import com.tang.user.component.MyAuthenicationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Classname UserResourceServer
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 13:46
 * @Created by ASUS
 */
@EnableResourceServer
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class UserResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .mvcMatchers("/api/**").permitAll()
                .mvcMatchers("/user/**")
                .hasAnyRole("USER")
                .mvcMatchers("/admin/**")
                .hasAnyRole("ADMIN")
                .anyRequest().authenticated();

        // 定义异常处理
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler())
                .authenticationEntryPoint(new MyAuthenicationEntryPoint());
    }
}