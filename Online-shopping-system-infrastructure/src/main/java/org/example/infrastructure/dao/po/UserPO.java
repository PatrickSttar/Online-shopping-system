package org.example.infrastructure.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 15:51
 */

@Data
public class UserPO {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}