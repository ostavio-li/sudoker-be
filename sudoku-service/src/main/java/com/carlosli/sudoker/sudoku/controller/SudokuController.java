package com.carlosli.sudoker.sudoku.controller;

import com.carlosli.common.pojo.Sudoku;
import com.carlosli.common.pojo.Product;
import com.carlosli.common.vo.ResultVO;
import com.carlosli.sudoker.sudoku.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author lijiancheng
 * @date 2021/7/22
 */

@RestController
@RequestMapping("/")
public class SudokuController {

    @Autowired
    private ProductClient client;

    @GetMapping("")
    public ResultVO<List<Product>> get() {
        return new ResultVO<>("200", "成功", client.list());
    }

    @GetMapping("/show")
    public ResultVO<Sudoku> show() {
        Sudoku sudoku = new Sudoku();
        int[][] data = new int[][]{
                {0, 7, 9, 0, 0, 0, 0, 6, 2},
                {0, 0, 0, 0, 3, 0, 8, 0, 0},
                {6, 8, 0, 0, 0, 9, 0, 0, 0},
                {5, 0, 0, 0, 9, 0, 0, 8, 3},
                {0, 0, 0, 0, 5, 2, 6, 0, 1},
                {0, 0, 7, 0, 0, 6, 0, 0, 0},
                {0, 0, 2, 1, 0, 3, 0, 0, 0},
                {1, 6, 0, 9, 0, 5, 2, 3, 4},
                {7, 5, 3, 8, 0, 4, 9, 0, 6}
        };
        sudoku.setData(data);
        return new ResultVO<Sudoku>().success().data(sudoku);

    }

}
