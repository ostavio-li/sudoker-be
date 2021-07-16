package com.carlosli.sudoker.product.controller;

import com.carlosli.sudoker.product.pojo.Product;
import com.carlosli.sudoker.product.service.IProductService;
import com.carlosli.sudoker.product.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */

@RestController
@RequestMapping("/p")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public Result<List<Product>> list() {
        return Result.success(productService.list());
    }

    @PostMapping("")
    public Result<Void> save(
            @RequestBody Product product
    ) {
        return productService.save(product) ? Result.success() : Result.error();
    }

    @PutMapping("")
    public void update() {

    }

    @DeleteMapping("")
    public void delete() {

    }

}
