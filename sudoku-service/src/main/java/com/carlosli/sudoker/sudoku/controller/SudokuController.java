package com.carlosli.sudoker.sudoku.controller;

import com.carlosli.common.pojo.Product;
import com.carlosli.common.vo.ResultVO;
import com.carlosli.sudoker.sudoku.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/7/22
 */

@RestController
@RequestMapping("/sudoku")
public class SudokuController {

    @Autowired
    private ProductClient client;

    @GetMapping("")
    public ResultVO<List<Product>> get() {
        List<Product> list = client.list().getData();
        return new ResultVO<>("200", "成功", list);
    }

}
