package com.abucloud.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/3/23 21:59
 */
@Data
public class UserInfoDTO {

    private Integer userId;

    @NotBlank(message = "登录账号不能为空")
    private String loginAccount;

    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{0,}$", message = "必须是汉字")
    private String name;
}
