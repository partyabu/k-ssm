package com.abucloud;

import com.abucloud.entity.TbUserInfo;
import com.abucloud.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/12 21:24
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class KTest {

    @Autowired
    private UserService userService;


  /*  @Test
    public void test01() {
        this.userService.selectList();
    }*/

    @Test
    public void test03() {

        List<TbUserInfo> userInfoList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            TbUserInfo tbUserInfo = new TbUserInfo();
            tbUserInfo.setLoginAccount("1" + i);
            tbUserInfo.setPassword("1");
            tbUserInfo.setUsername("1");
            tbUserInfo.setDeptId(0);
            tbUserInfo.setDataStatus("1");
            tbUserInfo.setCreateBy("1");
            tbUserInfo.setCreateTime(LocalDateTime.now());
            tbUserInfo.setUpdateBy("1");
            tbUserInfo.setUpdateTime(LocalDateTime.now());
            tbUserInfo.setRecordVersion(0);
            tbUserInfo.setUpdateCount(0);
            userInfoList.add(tbUserInfo);
        }
        this.userService.insertUser(userInfoList, 10);
    }

    /**
     * 分批次查询
     */
    @Test
    public void selectBatch() {
        // 查询总条数
        int totalCount = 10000;
        // 每次查询条数
        int queryBatchCount = 1000;
        // 已经查询的条数
        int passCount = 0;
        do {
            System.out.println("select * from a limit " + passCount + "," + queryBatchCount);
            passCount = queryBatchCount + passCount;
        } while (passCount <= totalCount);
    }
}
