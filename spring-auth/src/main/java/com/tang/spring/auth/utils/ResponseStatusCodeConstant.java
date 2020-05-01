package com.tang.spring.auth.utils;

/**
 * @Classname ResponseStatusCodeConstant
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 14:38
 * @Created by ASUS
 */
public class ResponseStatusCodeConstant {
    private ResponseStatusCodeConstant() {}

    public static final int OAUTH_TOKEN_FAILURE = 2001; // token 失效
    public static final int OAUTH_TOKEN_MISSING = 2008; // token 缺失
    public static final int OAUTH_TOKEN_DENIED  = 2009; // token 权限不足
}