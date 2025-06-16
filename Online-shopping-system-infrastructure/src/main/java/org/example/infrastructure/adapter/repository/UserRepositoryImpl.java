package org.example.infrastructure.adapter.repository;

import org.example.domain.user.adapter.repository.IUserRepository;
import org.example.domain.user.model.entity.UserEntity;
import org.example.infrastructure.dao.IUserDao;
import org.example.infrastructure.dao.po.UserPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 16:00
 */

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Resource
    private IUserDao userDao;

    @Override
    public UserEntity findByUsername(String username) {
        UserPO userPO = userDao.queryUserByUsername(username);
        if (null == userPO) return null;
        // PO -> Entity
        return UserEntity.builder()
                .username(userPO.getUsername())
                .password(userPO.getPassword())
                .build();
    }

    @Override
    public void save(UserEntity userEntity) {
        // Entity -> PO
        UserPO userPO = new UserPO();
        userPO.setUsername(userEntity.getUsername());
        userPO.setPassword(userEntity.getPassword());
        userDao.insertUser(userPO);
    }
}
