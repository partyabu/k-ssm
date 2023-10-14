package com.abucloud.controller;

import com.abucloud.bo.UserInfoBO;
import com.abucloud.entity.TbUserInfo;
import com.abucloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    private static Map<String, String> map = new HashMap<>();

    @RequestMapping("/oom")
    public String oom() throws Exception {
        for (int i = 0; i < 100000; i++) {
            map.put("key" + i, "value" + i);
        }
        return "oom";
    }

}
