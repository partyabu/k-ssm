package com.abucloud.service;

import com.abucloud.bo.UserInfoBO;
import com.abucloud.bo.UserRoleBO;
import com.abucloud.entity.TbUserInfo;

import java.util.List;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/3/26 12:37
 */
public interface UserService {

    // PageInfo selectList();

    TbUserInfo selectOne(Integer id);

    List<UserRoleBO> selectRoleByCondition(TbUserInfo userInfo);

    void insertRoleUser();

    void insertOneUser();

    void insertUser(List<TbUserInfo> userInfos, int batchSize);

    Integer deleteBatchUser(List<Integer> userIds);

    List<TbUserInfo> queryPagePhysics(UserInfoBO userInfoBO);

    List<TbUserInfo> queryPageLogic(UserInfoBO userInfoBO);
}
