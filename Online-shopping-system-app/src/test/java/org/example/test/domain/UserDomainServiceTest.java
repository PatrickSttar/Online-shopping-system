package org.example.test.domain;

import org.example.domain.user.adapter.repository.IUserRepository;
import org.example.domain.user.model.entity.UserEntity;
import org.example.domain.user.service.UserDomainService;
import org.example.types.exception.AppException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 18:29
 */


/**
 * 用户领域服务单元测试
 */
@ExtendWith(MockitoExtension.class)
public class UserDomainServiceTest {

    @InjectMocks
    private UserDomainService userDomainService;

    @Mock
    private IUserRepository userRepository;

    // ------------------- 注册功能测试 -------------------

    /**
     * 测试用例一：注册成功
     */
    @Test
    public void test_register_success() {
        // 1. 准备
        UserEntity newUser = new UserEntity("newUser", "password123");
        when(userRepository.findByUsername("newUser")).thenReturn(null);

        // 2. 执行
        userDomainService.register(newUser);

        // 3. 断言
        verify(userRepository, times(1)).save(newUser);
    }

    /**
     * 测试用例二：因用户名已存在而注册失败
     */
    @Test
    public void test_register_failure_when_user_exists() {
        // 1. 准备
        UserEntity existingUser = new UserEntity("existingUser", "password123");
        when(userRepository.findByUsername("existingUser")).thenReturn(new UserEntity());

        // 2. 执行与断言
        assertThrows(AppException.class, () -> userDomainService.register(existingUser));
        verify(userRepository, never()).save(any(UserEntity.class));
    }

    // ------------------- 登录功能测试 -------------------

    /**
     * 测试用例三：登录成功
     */
    @Test
    public void test_login_success() {
        // 1. 准备
        UserEntity userInDb = new UserEntity("testuser", "correct_password");
        UserEntity loginAttempt = new UserEntity("testuser", "correct_password");
        when(userRepository.findByUsername("testuser")).thenReturn(userInDb);

        // 2. 执行
        UserEntity result = userDomainService.login(loginAttempt);

        // 3. 断言
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
    }

    /**
     * 测试用例四：因用户不存在而登录失败
     */
    @Test
    public void test_login_failure_when_user_not_found() {
        // 1. 准备
        UserEntity loginAttempt = new UserEntity("non_existent_user", "password");
        when(userRepository.findByUsername("non_existent_user")).thenReturn(null);

        // 2. 执行与断言
        AppException exception = assertThrows(AppException.class, () -> userDomainService.login(loginAttempt));
        assertEquals("用户不存在", exception.getInfo());
    }

    /**
     * 测试用例五：因密码错误而登录失败
     */
    @Test
    public void test_login_failure_when_password_is_wrong() {
        // 1. 准备
        UserEntity userInDb = new UserEntity("testuser", "correct_password");
        UserEntity loginAttempt = new UserEntity("testuser", "wrong_password");
        when(userRepository.findByUsername("testuser")).thenReturn(userInDb);

        // 2. 执行与断言
        AppException exception = assertThrows(AppException.class, () -> userDomainService.login(loginAttempt));
        assertEquals("密码错误", exception.getInfo());
    }
}