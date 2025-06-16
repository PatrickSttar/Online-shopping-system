package org.example.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.types.enums.ResponseCode;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 7000723935764546321L;

    private String code;
    private String info;
    private T data;

    /**
     * 泛型化的成功响应构造器
     * @param data 成功时返回的数据
     * @return 带有数据的成功响应
     * @param <T> 数据的类型
     */
    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(data)
                .build();
    }

    /**
     * 带有布尔值的成功响应
     * @param success 布尔值
     * @return 带有布尔数据的成功响应
     */
    public static Response<Boolean> success(boolean success) {
        return Response.<Boolean>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(success)
                .build();
    }


    /**
     * 错误响应构造器
     * @param code 错误码
     * @param info 错误信息
     * @return 一个不带数据（或数据为null）的错误响应
     */
    public static <T> Response<T> error(String code, String info) {
        return Response.<T>builder()
                .code(code)
                .info(info)
                .build(); // 错误响应通常不携带data
    }
}