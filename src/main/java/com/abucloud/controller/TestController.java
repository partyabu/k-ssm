package com.abucloud.controller;

import com.abucloud.bo.UserInfoBO;
import com.abucloud.entity.TbUserInfo;
import com.abucloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  /*  @GetMapping("users")
    public PageInfo users() {
        return this.userService.selectList();
    }
*/
    /**
     * 数据校验以及分页
     *
     * @param userInfoDTO
     * @param bindingResult
     * @return
     */
/*
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
*/

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
/*    @GetMapping("testValidate02")
    public PageInfo testValidate02(@RequestBody @Validated UserInfoDTO userInfoDTO, BindingResult bindingResult) {

        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            stringBuilder.append(field).append(":").append(defaultMessage);
        });
        System.out.println(stringBuilder.toString());
        return this.userService.selectList();
    }*/

    /**
     * 分页查询: 物理分页
     *
     * @param userInfoBO
     * @return
     */
    @PostMapping("queryPagePhysics")
    public List<TbUserInfo> queryPagePhysics(@RequestBody UserInfoBO userInfoBO) {
        return this.userService.queryPagePhysics(userInfoBO);
    }

    /**
     * 分页查询: 逻辑分页
     *
     * @param userInfoBO
     * @return
     */
    @PostMapping("queryPageLogic")
    public List<TbUserInfo> queryPage(@RequestBody UserInfoBO userInfoBO) {
        return this.userService.queryPageLogic(userInfoBO);
    }

}
