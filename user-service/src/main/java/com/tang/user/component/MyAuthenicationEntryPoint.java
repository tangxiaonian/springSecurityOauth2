package com.tang.user.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname MyAuthenicationEntryPoint
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 12:11
 * @Created by ASUS
 */
public class MyAuthenicationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        System.out.println( " 身份没有验证的时候调用！ " );
    }
}