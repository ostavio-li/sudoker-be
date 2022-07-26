package com.carlosli.sudoker.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carlosli.sudoker.user.pojo.SysResource;
import com.carlosli.sudoker.user.pojo.SysUser;

import java.util.List;

/**
 * @author 李健成
 * @date 2021/12/24
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysResource> listResource(String username);

}
