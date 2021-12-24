package com.carlosli.sudoker.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.carlosli.common.vo.ResultVO;
import com.carlosli.sudoker.gateway.client.UserClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateRequestCustomizer;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * 网关全局过滤器
 * @author 李健成
 * @date 2021/12/24
 */

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    private final Logger logger = LogManager.getLogger("Gateway-TokenFilter");

//    @Autowired
//    private UserClient userClient;

    /**
     * 网关过滤逻辑
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // 读取 Token
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (token != null) {
            logger.info(token);

        } else {
            logger.warn("无 Token");

//            ResultVO<Void> result = new ResultVO<>(HttpStatus.UNAUTHORIZED.toString(), "未登录", null);
//
//            ServerHttpResponse response = exchange.getResponse();
//            byte[] cause = JSON.toJSONString(result).getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = response.bufferFactory().wrap(cause);
//            response.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
//            return response.writeWith(Mono.just(buffer));
        }


//        WebClient webClient = WebClient.create();
//        Mono<ResultVO> resultVOMono = webClient.get().uri("http://user-service/u").retrieve().bodyToMono(ResultVO.class);
//        resultVOMono.then()

//        logger.info(result.toString());


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
