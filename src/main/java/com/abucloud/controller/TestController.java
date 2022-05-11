package com.abucloud.controller;

import com.abucloud.bo.UserInfoBO;
import com.abucloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<UserInfoBO> users() {
        return this.userService.selectList();
    }
}
