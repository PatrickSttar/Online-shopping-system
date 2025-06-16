package org.example.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.dao.po.UserPO;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 15:53
 */

@Mapper
public interface IUserDao {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户PO对象
     */
    UserPO queryUserByUsername(String username);

    /**
     * 插入用户
     * @param userPO 用户PO对象
     */
    void insertUser(UserPO userPO);

}