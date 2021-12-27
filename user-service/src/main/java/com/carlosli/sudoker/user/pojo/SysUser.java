package com.carlosli.sudoker.user.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = -2972177886426469678L;

    private Long id;
    private String username;
    private String password;

}
