package com.carlosli.sudoker.sudoku.client;

import com.carlosli.common.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.carlosli.common.vo.ResultVO;

import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/8/31
 */

@FeignClient(value = "product-service")
public interface ProductClient {
    @GetMapping("/p")
    List<Product> list();
}
