package com.carlosli.common.exc;

/**
 * @author 李健成
 * @date 2021/12/29
 */
public class AuthenticateException extends RuntimeException {

    private static final long serialVersionUID = 2398474279548304242L;

    public AuthenticateException(String message) {
        super(message);
    }

}
