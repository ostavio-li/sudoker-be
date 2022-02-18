package com.carlosli.sudoker.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.carlosli.common.exc.AuthenticateException;
import com.carlosli.common.exc.UserNotFoundException;
import com.carlosli.common.util.TokenUtil;
import com.carlosli.common.vo.LoginVO;
import com.carlosli.common.vo.ResultVO;
import com.carlosli.sudoker.user.pojo.SysResource;
import com.carlosli.sudoker.user.pojo.SysUser;
import com.carlosli.sudoker.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@Slf4j
@RestController
@RequestMapping("/")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public ResultVO<String> login(@RequestBody LoginVO loginVO) {

        log.info("开始登录...");

        String username = loginVO.getUsername();
        String password = loginVO.getPassword();

        log.info("{} -- {}", username, password);
        LambdaQueryWrapper<SysUser> usernameWrapper = new QueryWrapper<SysUser>().lambda()
                .eq(SysUser::getUsername, username);
        List<SysUser> users = userService.list(usernameWrapper);
        if (users.isEmpty()) {
            throw new UserNotFoundException("用户 " + username + " 不存在");
        } else {
            SysUser user = users.get(0);
            if (password.equals(user.getPassword())) {
//                redisTemplate.opsForValue().set(username, password);

                return new ResultVO<String>().success().data(TokenUtil.generate(username));
            } else {
                throw new AuthenticateException("密码错误");
            }
        }

    }

    @GetMapping("/resource")
    public ResultVO<List<SysResource>> listResource(String username) {
        List<SysResource> resources = userService.listResource(username);
        return new ResultVO<List<SysResource>>().success().data(resources);
    }

//    @PostMapping("/auth")
//    public ResultVO<Boolean> auth(String username, String path) {
//
//    }

}
