package com.abucloud.service.impl;

import com.abucloud.bo.UserRoleBO;
import com.abucloud.entity.TbRoleInfo;
import com.abucloud.entity.TbUserInfo;
import com.abucloud.mapper.TbRoleInfoMapper;
import com.abucloud.mapper.UserInfoMapper;
import com.abucloud.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/3/26 12:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private TbRoleInfoMapper roleInfoMapper;

    @Autowired
    private UserService userService;

    @Override
    public PageInfo<TbUserInfo> selectList() {
       return PageHelper
                .startPage(1, 10)
                .doSelectPageInfo(() -> userInfoMapper.selectList());

    }

    @Override
    public TbUserInfo selectOne(Integer id) {
        return this.userInfoMapper.selectOne(id);
    }

    @Override
    public List<UserRoleBO> selectRoleByCondition(TbUserInfo userInfo) {
        return this.userInfoMapper.selectRoleByCondition(userInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertUser(List<TbUserInfo> userInfos, int batchSize) {

        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        int totalSize = userInfos.size();
        int count = 1;

        try {
            for (TbUserInfo tbUserInfo : userInfos) {

                userInfoMapper.insertUser(tbUserInfo);

                // ??????batchSize??????????????????count???????????????????????????
                if (count % batchSize == 0 || count == totalSize) {
                    sqlSession.commit();
                }

                count++;
            }
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public Integer deleteBatchUser(List<Integer> userIds) {
        return this.userInfoMapper.deleteBatch(userIds);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertRoleUser() {
        TbRoleInfo tbRoleInfo = new TbRoleInfo();
        tbRoleInfo.setRoleName("xxx");
        tbRoleInfo.setRoleDesc("desc");
        this.roleInfoMapper.insertOneUser(tbRoleInfo);
        this.userService.insertOneUser();
    }

    /**
     * ???????????????????????????????????????????????????????????? @Transactional??????????????????
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertOneUser() {
        TbUserInfo tbUserInfo = new TbUserInfo();
        tbUserInfo.setLoginAccount("1");
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
        this.userInfoMapper.insertUser(tbUserInfo);
        // int a = 1 / 0;

    }
}
