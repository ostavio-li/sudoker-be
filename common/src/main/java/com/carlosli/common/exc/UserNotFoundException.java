package com.carlosli.common.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 李健成
 * @date 2021/12/29
 */

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5083495196031050442L;

    public UserNotFoundException(String message) {
        super(message);
    }

}
