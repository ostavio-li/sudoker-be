package com.carlosli.sudoker.sudoku.controller;

import com.carlosli.common.pojo.Board;
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
@RequestMapping("/")
public class SudokuController {

    @Autowired
    private ProductClient client;

    @GetMapping("")
    public ResultVO<List<Product>> get() {
        return new ResultVO<>("200", "成功", client.list());
    }

    @GetMapping("/show")
    public ResultVO<Board> show() {
        Board board = new Board();
        int[][] data = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 2, 5, 9, 3, 4, 7, 1, 6},
                {7, 1, 9, 3, 6, 5, 4, 7, 2},
                {2, 1, 3, 4, 8, 9, 7, 5, 6},
                {7, 6, 9, 1, 8, 2, 4, 5, 3},
                {9, 6, 3, 1, 2, 4, 7, 8, 5},
                {4, 3, 2, 1, 9, 8, 7, 6, 5},
                {6, 5, 4, 9, 8, 7, 3, 2, 1},
                {3, 2, 1, 6, 5, 4, 9, 8, 7}
        };
        board.setData(data);
        return new ResultVO<Board>().success().data(board);

    }

}
