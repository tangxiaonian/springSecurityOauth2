package com.tang.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/5/1 13:41
 * @Created by ASUS
 */
@RequestMapping("/api")
@RestController
public class ApiController {

    @GetMapping("/test")
    public String test() {
        return "api test!";
    }

}