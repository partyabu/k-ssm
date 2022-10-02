package com.abucloud.bo;


import com.abucloud.entity.TbUserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/3/23 21:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoBO extends PageRequest implements Comparable{

    private Integer userId;

    private String loginAccount;

    private List<TbUserInfo> loginAccountList;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
