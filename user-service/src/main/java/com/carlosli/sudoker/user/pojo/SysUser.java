package com.carlosli.sudoker.user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@Data
public class SysUser implements Serializable {

    public static final long serialVersionUID = -50005L;

    private Long id;
    private String sysUsername;


}
