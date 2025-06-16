package org.example.api.dto;

import lombok.Data;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 16:02
 */

@Data
public class UserRegisterRequestDTO {
    private String username;
    private String password;
}