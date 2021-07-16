package com.carlosli.sudoker.product.constant;

import lombok.AllArgsConstructor;

/**
 * @author Carlos Li
 * @date 2021/7/4
 */

@AllArgsConstructor
public enum StatusCodeEnum {

    // 成功
    SUCCESS("200", "成功"),
    // 登录成功
    LOGIN_SUCCESS("201", "登录成功"),
    // 登出成功
    LOGOUT_SUCCESS("202", "退出成功"),
    // 业务异常
    BUSINESS_ERROR("501", "业务异常"),
    // 服务器错误
    SERVER_ERROR("500", "服务器错误"),
    // Session 过期
    INVALID_SESSION("501", "Session 过期"),
    // 客户端错误
    CLIENT_ERROR("400", "客户端错误"),
    // 无权限
    NO_PERMISSION("1000", "无权限"),
    // 未登录
    NOT_LOGIN("1003", "未登录"),
    // 密码错误
    WRONG_PASSWORD("1001", "密码错误"),
    // 用户不存在
    USER_NOT_EXISTS("1002", "该用户不存在"),
    // 未知错误
    UNKNOWN_ERROR("000", "未知错误");

    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}