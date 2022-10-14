package com.abucloud.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: party-abu
 * @create: 2022-09-15 22:14
 */
@Data
public class PageRequest implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 第几页
     */
    private Integer pageNo;

    /**
     * 每页多少条
     */
    private Integer pageSize;

    /**
     * 偏移量计算方式：(pageNo - 1) * pageSize。
     * mybatis #{offset}调用的是getOffset方法
     */
    public Integer getOffset() {
        return ((pageNo == null || pageNo < 1 ? 1 : pageNo) - 1)
                * (pageSize == null ? 10 : pageSize);
    }


    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

}
