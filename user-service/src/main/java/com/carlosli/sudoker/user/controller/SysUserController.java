package com.carlosli.sudoker.user.controller;

import com.carlosli.sudoker.user.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@RestController
@RequestMapping("/u")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @GetMapping("")
    public void list() {

    }

}
