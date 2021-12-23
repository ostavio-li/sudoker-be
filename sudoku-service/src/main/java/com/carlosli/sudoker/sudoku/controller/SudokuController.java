package com.carlosli.sudoker.sudoku.controller;

import com.alibaba.fastjson.JSONArray;
import com.carlosli.common.pojo.Sudoku;
import com.carlosli.common.pojo.Product;
import com.carlosli.common.vo.ResultVO;
import com.carlosli.sudoker.sudoku.client.ProductClient;
import com.carlosli.sudoker.sudoku.dto.SudokuDO;
import com.carlosli.sudoker.sudoku.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private SudokuService sudokuService;

    @GetMapping("")
    public ResultVO get() {
        SudokuDO sudokuDO = sudokuService.getById(1);
        List<int[]> list = JSONArray.parseArray(sudokuDO.getSudoku(), int[].class);
        int[][] data = new int[9][9];
        return new ResultVO("200", "成功", new Sudoku(list.toArray(data)));
    }

    @PostMapping("")
    public ResultVO save() {
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
        sudokuService.save(sudokuService.asString(sudoku));
        return new ResultVO().success();
    }

    /**
     * @deprecated replaced by <code>get()</code>
     * @return result
     */
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
