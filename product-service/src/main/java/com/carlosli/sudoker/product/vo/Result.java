package com.carlosli.sudoker.product.vo;

import com.carlosli.sudoker.product.constant.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Carlos Li
 * @date 2021/7/4
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {

    private String code;
    private String msg;
    private T data;

    public static Result<Void> success(StatusCodeEnum statusCode) {
        return Result.<Void>builder()
                .code(statusCode.getCode())
                .msg(statusCode.getMsg())
                .build();
    }

    public static Result<Void> success() {
        return Result.<Void>builder()
                .code(StatusCodeEnum.SUCCESS.getCode())
                .msg(StatusCodeEnum.SUCCESS.getMsg())
                .build();
    }

    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .code(StatusCodeEnum.SUCCESS.getCode())
                .msg(StatusCodeEnum.SUCCESS.getMsg())
                .data(data)
                .build();
    }

    public static Result<Void> error() {
        return Result.<Void>builder()
                .code(StatusCodeEnum.SERVER_ERROR.getCode())
                .msg(StatusCodeEnum.SERVER_ERROR.getMsg())
                .build();
    }

    public static Result<Void> error(String msg) {
        return Result.<Void>builder()
                .code(StatusCodeEnum.SERVER_ERROR.getCode())
                .msg(msg)
                .build();
    }

    public static Result<Void> error(StatusCodeEnum statusCode) {
        return Result.<Void>builder()
                .code(statusCode.getCode())
                .msg(statusCode.getMsg())
                .build();
    }

    public static Result<Void> error(StatusCodeEnum statusCode, String msg) {
        return Result.<Void>builder()
                .code(statusCode.getCode())
                .msg(msg)
                .build();
    }

    public static Result<Void> error(String code, String msg) {
        return Result.<Void>builder()
                .code(code)
                .msg(msg)
                .build();
    }


}
