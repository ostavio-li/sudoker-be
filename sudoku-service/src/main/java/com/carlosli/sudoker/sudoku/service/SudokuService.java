package com.carlosli.sudoker.sudoku.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carlosli.common.pojo.Sudoku;
import com.carlosli.sudoker.sudoku.dto.SudokuDO;
import com.carlosli.sudoker.sudoku.mapper.SudokuMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李健成
 * @date 2021/11/1
 */

@Service
public class SudokuService extends ServiceImpl<SudokuMapper, SudokuDO> {

//    public void getSudoku() {
//        List<SudokuDO> list = this.list();
//        SudokuDO sudokuDO = list.get(0);
//        String sudokuStr = sudokuDO.getSudoku();
//
//    }

    public String asString(Sudoku sudoku) {
        return JSON.toJSONString(sudoku.getData());
    }

    public boolean save(String sudokuStr) {
        return super.save(new SudokuDO(null, sudokuStr));
    }
}
