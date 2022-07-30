package com.abucloud.controller;

import com.abucloud.dto.UserInfoDTO;
import com.abucloud.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/11 19:14
 */
@Slf4j
@RequestMapping("one")
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("isOk")
    public String testOk() {
        log.info("ok..............");
        return "ok";
    }

    @GetMapping("users")
    public PageInfo users() {
        return this.userService.selectList();
    }

    /**
     * 数据校验以及分页
     *
     * @param userInfoDTO
     * @param bindingResult
     * @return
     */
    @GetMapping("testValidate")
    public PageInfo users(@RequestBody @Validated UserInfoDTO userInfoDTO, BindingResult bindingResult) {

        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            stringBuilder.append(field).append(":").append(defaultMessage);
        });
        System.out.println(stringBuilder.toString());
        return this.userService.selectList();
    }

    /**
     * 批量删除
     *
     * @param userIds
     * @return
     */
    @GetMapping("deleteBatch")
    public Integer deleteBatchUser(@RequestBody List<Integer> userIds) {
        return this.userService.deleteBatchUser(userIds);
    }

    /**
     * 数据校验以及分页
     *
     * @param userInfoDTO
     * @param bindingResult
     * @return
     */
    @GetMapping("testValidate02")
    public PageInfo testValidate02(@RequestBody @Validated UserInfoDTO userInfoDTO, BindingResult bindingResult) {

        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            stringBuilder.append(field).append(":").append(defaultMessage);
        });
        System.out.println(stringBuilder.toString());
        return this.userService.selectList();
    }
}
