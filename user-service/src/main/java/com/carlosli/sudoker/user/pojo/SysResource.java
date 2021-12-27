package com.carlosli.sudoker.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_resource")
public class SysResource {
    @TableId(type = IdType.INPUT)
    private String resourceCode;
    private String resourcePath;
    private String resourceMethod;
}
