package com.tang.spring.auth.component;

import com.tang.spring.auth.utils.ResponseCodeConstant;
import com.tang.spring.auth.utils.ResponseMessageConstant;
import com.tang.spring.auth.utils.ResponseStatusCodeConstant;
import com.tang.spring.auth.utils.ResultJsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname CustomAccessDeniedHandler
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 14:42
 * @Created by ASUS
 */
@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(ResultJsonUtil.build(
                    ResponseCodeConstant.REQUEST_FAILED,
                    ResponseStatusCodeConstant.OAUTH_TOKEN_DENIED,
                    ResponseMessageConstant.OAUTH_TOKEN_DENIED
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
