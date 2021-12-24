package com.carlosli.sudoker.gateway.client;

import com.carlosli.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李健成
 * @date 2021/12/24
 */

@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping("/u")
    ResultVO<String> list();

}
