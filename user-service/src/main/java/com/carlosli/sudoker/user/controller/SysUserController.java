package com.carlosli.sudoker.user.controller;

import com.carlosli.common.vo.LoginVO;
import com.carlosli.common.vo.ResultVO;
import com.carlosli.sudoker.user.pojo.SysResource;
import com.carlosli.sudoker.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@RestController
@RequestMapping("/")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    public ResultVO<String> login(@RequestBody LoginVO loginVO) {

        return new ResultVO<>("200", "哈哈哈", "这是 " + loginVO.getUsername());
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
