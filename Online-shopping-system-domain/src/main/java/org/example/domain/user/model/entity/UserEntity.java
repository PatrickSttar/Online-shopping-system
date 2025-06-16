package org.example.domain.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 15:56
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String username;
    private String password;

    // 在真实的业务场景中，这里可以添加业务方法
    // 例如：public boolean checkPassword(String plainPassword) { ... }
}