package org.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 16:03
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDTO {
    private String token;
}