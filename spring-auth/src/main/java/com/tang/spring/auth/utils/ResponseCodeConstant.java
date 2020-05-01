package com.tang.spring.auth.utils;

/**
 * @Classname ResponseCodeConstant
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 14:38
 * @Created by ASUS
 */
public class ResponseCodeConstant {
    private ResponseCodeConstant() {}

    public static final int REQUEST_SUCCESS = 1; // 请求成功
    public static final int REQUEST_FAILED  = 0; // 请求失败
    public static final int SYSTEM_ERROR    = -1; // 系统错误
}