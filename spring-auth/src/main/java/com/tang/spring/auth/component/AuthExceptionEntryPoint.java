package com.tang.spring.auth.component;

import com.tang.spring.auth.utils.ResponseCodeConstant;
import com.tang.spring.auth.utils.ResponseMessageConstant;
import com.tang.spring.auth.utils.ResponseStatusCodeConstant;
import com.tang.spring.auth.utils.ResultJsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname AuthExceptionEntryPoint
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 14:35
 * @Created by ASUS
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws ServletException {
        Map<String, Object> map = new HashMap<>();
        Throwable cause = authException.getCause();

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            if(cause instanceof InvalidTokenException) {
                response.getWriter().write(ResultJsonUtil.build(
                        ResponseCodeConstant.REQUEST_FAILED,
                        ResponseStatusCodeConstant.OAUTH_TOKEN_FAILURE,
                        ResponseMessageConstant.OAUTH_TOKEN_ILLEGAL
                ));
            }else{
                response.getWriter().write(ResultJsonUtil.build(
                        ResponseCodeConstant.REQUEST_FAILED,
                        ResponseStatusCodeConstant.OAUTH_TOKEN_MISSING,
                        ResponseMessageConstant.OAUTH_TOKEN_MISSING
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}