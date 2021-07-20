package com.carlosli.sudoker.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 反网关绕过 Filter
 * @author lijiancheng
 * @date 2021/7/16
 */
public class AntiBypassFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest build = exchange.getRequest().mutate().header("from", "gateway").build();
        return chain.filter(exchange.mutate().request(build.mutate().build()).build());
    }
}
