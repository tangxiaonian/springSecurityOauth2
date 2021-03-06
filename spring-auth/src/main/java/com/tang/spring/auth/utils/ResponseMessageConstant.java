package com.tang.spring.auth.utils;

/**
 * @Classname ResponseMessageConstant
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 14:39
 * @Created by ASUS
 */
public class ResponseMessageConstant {
    private ResponseMessageConstant() {}

    public static final String REQUEST_SUCCESS            = "请求成功";
    public static final String REQUEST_FAILED             = "请求失败";
    public static final String SYSTEM_ERROR               = "系统错误";
    public static final String APP_EXCEPTION              = "应用程序异常";
    public static final String OAUTH_TOKEN_MISSING        = "token 缺失";
    public static final String OAUTH_TOKEN_ILLEGAL        = "token 格式非法或已失效";
    public static final String OAUTH_TOKEN_DENIED         = "token 权限不足";
    public static final String OAUTH_TOKEN_CHECK_ERROR    = "token 验证失败";
    public static final String SIGN_CHECK_ERROR           = "签名验证失败";
}