package com.abucloud.controller;

import com.abucloud.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/11 19:14
 */
@RequestMapping("one")
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("isOk")
    public String testOk() {
        return "ok";
    }

    @GetMapping("users")
    public PageInfo users() {
        return this.userService.selectList();
    }
}
