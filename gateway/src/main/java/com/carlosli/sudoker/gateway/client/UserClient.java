package com.carlosli.sudoker.gateway.client;

import com.carlosli.common.vo.LoginVO;
import com.carlosli.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 李健成
 * @date 2021/12/24
 */

@FeignClient(value = "user-service", path = "/u")
public interface UserClient {

    @PostMapping("/login")
    ResultVO<String> login(@RequestBody LoginVO loginVO);

}
