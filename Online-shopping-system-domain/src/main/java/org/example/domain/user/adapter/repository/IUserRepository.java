package org.example.domain.user.adapter.repository;

import org.example.domain.user.model.entity.UserEntity;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 15:55
 */
public interface IUserRepository {

    /**
     * 根据用户名查询用户实体
     *
     * @param username 用户名
     * @return 用户实体，如果不存在则返回 null
     */
    UserEntity findByUsername(String username);

    /**
     * 保存用户实体（用于注册新用户）
     *
     * @param userEntity 用户实体
     */
    void save(UserEntity userEntity);

}