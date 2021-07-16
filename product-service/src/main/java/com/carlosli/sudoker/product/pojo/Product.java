package com.carlosli.sudoker.product.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.carlosli.sudoker.product.constant.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("product")
public class Product implements Serializable {

    public static final long serialVersionUID = -50050L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String productName;
    private ProductType productType;
    private String productDesc;
    private Double productPrice;
    private Integer productQuantity;

}
