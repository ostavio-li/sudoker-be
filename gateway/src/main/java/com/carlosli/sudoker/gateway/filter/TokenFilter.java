package com.carlosli.sudoker.gateway.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSON;
import com.carlosli.common.client.SysUserClient;
import com.carlosli.common.util.TokenUtil;
import com.carlosli.common.vo.ResultVO;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * 网关全局过滤器
 * @author 李健成
 * @date 2021/12/24
 */

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    private final Logger logger = LogManager.getLogger("Gateway-TokenFilter");

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Autowired
    private SysUserClient sysUserClient;

    /**
     * 白名单
     */
    private static final List<String> ALLOW_LIST = Collections.singletonList("/api/user/login");

    /**
     * 网关过滤逻辑<br/>
     * 校验 Token
     */
    @SuppressWarnings("BlockingMethodInNonBlockingContext")
    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        HttpMethod method = request.getMethod();

        String path = request.getPath().value();

        // 请求无需鉴权，直接放通
        // 包括 未登录即可访问的接口
        if (ALLOW_LIST.contains(path)) {
            logger.info("无需鉴权");
            return chain.filter(exchange);
        }

        // 继续执行，则说明需要校验 Token

        // 读取 Token
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            // 解析 Token
            boolean checked = TokenUtil.check(token);
            if (!checked) {
                // jwt 校验失败
                logger.warn("Token 异常");
                ResultVO<Void> result = new ResultVO<>("500", "Token无效", null);
                ServerHttpResponse response = exchange.getResponse();
                byte[] cause = JSON.toJSONString(result).getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = response.bufferFactory().wrap(cause);
                response.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));
            } else {
                // 开始鉴权
                JWT jwt = JWTUtil.parseToken(token);
                String username = (String) jwt.getPayload("username");
                logger.info("用户名: {}, 请求: {}", username, path);
//                Boolean authed = sysUserClient.auth(username, path);
                Future<Boolean> future = executorService.submit(() -> sysUserClient.auth(username, path));
                Boolean authed = future.get();
                if (authed) {
                    ServerHttpRequest httpRequest = exchange.getRequest().mutate().header("username", username).build();
                    exchange = exchange.mutate().request(httpRequest).build();
                    return chain.filter(exchange);
                } else {
                    ResultVO<Void> result = new ResultVO<>("500", "无权限", null);
                    ServerHttpResponse response = exchange.getResponse();
                    byte[] cause = JSON.toJSONString(result).getBytes(StandardCharsets.UTF_8);
                    DataBuffer buffer = response.bufferFactory().wrap(cause);
                    response.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
                    return response.writeWith(Mono.just(buffer));
                }
            }

        } else {
            // 无 Token，直接返回未登录
            logger.warn("无 Token");

            ResultVO<Void> result = new ResultVO<>("500", "未登录", null);
//
            ServerHttpResponse response = exchange.getResponse();
            byte[] cause = JSON.toJSONString(result).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(cause);
            response.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }


//        WebClient webClient = WebClient.create();
//        Mono<ResultVO> resultVOMono = webClient.get().uri("http://user-service/u").retrieve().bodyToMono(ResultVO.class);
//        resultVOMono.then()

//        logger.info(result.toString());


    }

    /**
     * 最高优先级
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
