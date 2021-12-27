package com.carlosli.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李健成
 * @date 2021/12/27
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private String username;
    private String password;

}
