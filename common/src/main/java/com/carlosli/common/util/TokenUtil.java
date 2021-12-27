package com.carlosli.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;

/**
 * jwt 工具
 * @author 李健成
 * @date 2021/12/27
 */

public class TokenUtil {

    public static String generate(String username) {
        return JWT.create()
                .setPayload("username", username)
                .setExpiresAt(DateUtil.tomorrow())
                .setSigner(JWTSignerUtil.none())
                .sign();
    }

    public static void main(String[] args) {
        System.out.println(generate("拉美西斯"));
    }

    public static boolean check(String token) {
        // TODO: 2021/12/27 校验Token
        try {
            JWTValidator.of(token).validateDate(DateUtil.date());
        } catch (ValidateException e) {
            return false;
        }
        return true;
    }



}
