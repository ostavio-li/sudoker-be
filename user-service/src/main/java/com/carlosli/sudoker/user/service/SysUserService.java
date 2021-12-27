package com.carlosli.sudoker.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carlosli.sudoker.user.mapper.SysUserMapper;
import com.carlosli.sudoker.user.pojo.SysResource;
import com.carlosli.sudoker.user.pojo.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    public List<SysResource> listResource(String username) {
        return baseMapper.listResource(username);
    }

}