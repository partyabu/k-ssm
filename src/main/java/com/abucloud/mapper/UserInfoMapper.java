package com.abucloud.mapper;


import com.abucloud.bo.PageRequest;
import com.abucloud.bo.UserInfoBO;
import com.abucloud.bo.UserRoleBO;
import com.abucloud.entity.TbUserInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * <p>
 * 用户信息表  Mapper 接口
 * </p>
 *
 * @author liukang
 * @since 2021-08-22
 */
public interface UserInfoMapper {

    List<UserInfoBO> selectList();

    TbUserInfo selectOne(Integer id);

    List<UserRoleBO> selectRoleByCondition(TbUserInfo userInfo);

    int insertUser(TbUserInfo tbUserInfoList);

    Integer deleteBatch(List<Integer> userIds);

    List<TbUserInfo> queryPagePhysics(PageRequest pageRequest);

    List<TbUserInfo> queryPageLogic(UserInfoBO userInfoBO, RowBounds rowBounds);

    void insertBatch(List<TbUserInfo> entities);

    void updateBatch(List<TbUserInfo> userInfoList);
}
