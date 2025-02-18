package com.abucloud.mapper;

import com.abucloud.entity.TbRoleInfo;
import com.abucloud.entity.TbUserInfo;

import java.util.List;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/1 22:56
 */
public interface TbRoleInfoMapper {
    /**
     * com/abucloud/mapper/TbRoleInfoMapper.xml
     * @param tbRoleInfo
     */
    void insertOneUser(TbRoleInfo tbRoleInfo);

    /**
     * com/abucloud/mapper/TbRoleInfoMapper.xml
     * @param tbRoleInfoList
     */
    int updateBatch(List<TbUserInfo> tbRoleInfoList);
}
