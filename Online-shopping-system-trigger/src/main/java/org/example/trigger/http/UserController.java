package org.example.trigger.http;

import org.example.api.dto.UserLoginRequestDTO;
import org.example.api.dto.UserLoginResponseDTO;
import org.example.api.dto.UserRegisterRequestDTO;
import org.example.api.response.Response;
import org.example.domain.user.model.entity.UserEntity;
import org.example.domain.user.service.UserDomainService;
import org.example.trigger.util.JwtUtil;
import org.example.types.exception.AppException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserDomainService userDomainService;

    @PostMapping("/register")
    public Response<Boolean> register(@RequestBody UserRegisterRequestDTO request) {
        try {
            UserEntity userEntity = UserEntity.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .build();
            userDomainService.register(userEntity);
            return Response.success(true);
        } catch (AppException e) {
            // 业务异常，打印信息后返回
            e.printStackTrace();
            return Response.error(e.getCode(), e.getInfo());
        } catch (Exception e) {
            // 【关键修改】在这里打印出未知的异常信息
            e.printStackTrace();
            return Response.error("500", "注册失败，请稍后再试");
        }
    }

    @PostMapping("/login")
    public Response<UserLoginResponseDTO> login(@RequestBody UserLoginRequestDTO request) {
        try {
            UserEntity userEntity = UserEntity.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .build();
            userDomainService.login(userEntity);

            String token = JwtUtil.generateToken(request.getUsername());
            UserLoginResponseDTO responseDTO = UserLoginResponseDTO.builder()
                    .token(token)
                    .build();

            return Response.success(responseDTO);
        } catch (AppException e) {
            e.printStackTrace();
            return Response.error(e.getCode(), e.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("500", "登录失败，请稍后再试");
        }
    }
}