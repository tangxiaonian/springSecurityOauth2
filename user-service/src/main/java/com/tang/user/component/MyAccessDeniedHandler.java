package com.tang.user.component;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname MyAccessDeniedHandler
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 12:10
 * @Created by ASUS
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");

        System.out.println( " 没有权限访问资源时触发! " );

        response.setStatus(403);

        response.getWriter().print("你没有权限访问啊，弟弟!");

    }

}