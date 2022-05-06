package com.carlosli.common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李健成
 * @date 2022/5/6
 */

@FeignClient(value = "user-service")
public interface SysUserClient {

    @PostMapping("/auth")
    Boolean auth(@RequestParam String username, @RequestParam String path);

}
