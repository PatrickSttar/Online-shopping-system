package org.example.api.dto;

import lombok.Data;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 16:03
 */

@Data
public class UserLoginRequestDTO {
    private String username;
    private String password;
}