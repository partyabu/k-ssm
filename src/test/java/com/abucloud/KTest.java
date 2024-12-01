package com.abucloud;

import com.abucloud.entity.TbUserInfo;
import com.abucloud.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Arrays;

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

    @Autowired
    private TbUserInfo tbUserInfo;


    @Autowired
    private TransactionTemplate transactionTemplate;


    @Test
    public void test01() {

        // transactionTemplate.executeWithoutResult(t -> {

            this.userService.selectOne("aaaaaa");
            System.out.println("1111111111");
            this.userService.selectOne("aaaaaa");
        // });

    }

    @Test
    public void test06() {
        //
        // this.userService.selectOne(1);
        // this.userService.selectOne(2);

    }

    @Test
    public void test03() {

        // List<TbUserInfo> userInfoList = new ArrayList<>(10);
        // for (int i = 0; i < 10; i++) {
        //     TbUserInfo tbUserInfo = new TbUserInfo();
        //     tbUserInfo.setLoginAccount("1" + i);
        //     tbUserInfo.setPassword("1");
        //     tbUserInfo.setUsername("1");
        //     tbUserInfo.setDeptId(0);
        //     tbUserInfo.setDataStatus("1");
        //     tbUserInfo.setCreateBy("1");
        //     tbUserInfo.setCreateTime(LocalDateTime.now());
        //     tbUserInfo.setUpdateBy("1");
        //     tbUserInfo.setUpdateTime(LocalDateTime.now());
        //     tbUserInfo.setRecordVersion(0);
        //     tbUserInfo.setUpdateCount(0);
        //     userInfoList.add(tbUserInfo);
        // }
        // this.userService.insertUser(userInfoList,10);
    }


    @Test
    public void test02() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // TbUserInfo tbUserInfo = TbUserInfo.class.newInstance();
        Class<?> aClass = Class.forName("com.abucloud.entity.TbUserInfo");
        Object o = aClass.newInstance();
        System.out.println("tbUserInfo = " + o);
    }

    @Test
    public void test05() {
        int nums[] = new int[]{
                1, 2, 2, 4
        };

        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
}
