package org.example.trigger.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 16:04
 */

public class JwtUtil {

    // 密钥硬编码。真实项目中应放在配置文件
    private static final String SECRET_KEY = "your-very-secret-key-for-school-project";
    // 过期时间（毫秒），这里设置为1天
    private static final long EXPIRATION_TIME = 86400000; // 24 * 60 * 60 * 1000

    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}