package org.example.domain.user.service;

import org.example.domain.user.adapter.repository.IUserRepository;
import org.example.domain.user.model.entity.UserEntity;
import org.example.types.exception.AppException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 15:58
 */

@Service
public class UserDomainService {

    @Resource
    private IUserRepository userRepository;

    /**
     * 用户注册
     * @param userEntity 用户实体
     */
    public void register(UserEntity userEntity) {
        // 1. 检查用户名是否已存在
        UserEntity existingUser = userRepository.findByUsername(userEntity.getUsername());
        if (null != existingUser) {
            throw new AppException("此用户名已被注册");
        }
        // 2. 保存新用户
        userRepository.save(userEntity);
    }

    /**
     * 用户登录
     * @param userEntity 用户实体
     * @return 登录成功的用户实体
     */
    public UserEntity login(UserEntity userEntity) {
        // 1. 查找用户
        UserEntity foundUser = userRepository.findByUsername(userEntity.getUsername());
        if (null == foundUser) {
            throw new AppException("用户不存在");
        }
        // 2. 校验密码 (简化版，直接对比字符串)
        if (!foundUser.getPassword().equals(userEntity.getPassword())) {
            throw new AppException("密码错误");
        }
        return foundUser;
    }
}