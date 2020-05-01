package com.tang.spring.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tang.spring.auth.component.CustomOauthExceptionSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @Classname CustomOauthException
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 15:40
 * @Created by ASUS
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
    public CustomOauthException(String msg) {
        super(msg);
    }
}