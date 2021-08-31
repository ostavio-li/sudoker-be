package com.carlosli.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lijiancheng
 * @date 2021/8/31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -5381150603034981779L;

    private String code;
    private String message;
    private T data;

    public ResultVO<T> success() {
        this.code = "200";
        return this;
    }

    public ResultVO<T> data(T data) {
        this.data = data;
        return this;
    }

}
