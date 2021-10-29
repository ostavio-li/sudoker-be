package com.carlosli.common.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author lijiancheng
 * @date 2021/9/1
 */

@Data
@AllArgsConstructor
public class Sudoku implements Serializable {

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;

    private static final long serialVersionUID = -6533099186502639008L;

    private int[][] data;

    public Sudoku() {
        this.data = new int[ROWS][COLUMNS];
        this.init(0);
    }

    /**
     * 初始化，填充 init
     * @param init 填充数
     */
    public void init(int init) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.data[i][j] = init;
            }
        }
    }

    public int[] getRow(int row) {
        return this.data[row];
    }

    public int[] getCol(int col) {
        int[] column = new int[9];
        for (int i = 0; i < data.length; i++) {
            column[i] = this.data[i][col];
        }
        return column;
    }

    public int[][] getPalace(int x, int y) {
        int palaceRow = 0;
        int palaceCol = 0;
        int[][] palace = new int[3][3];
        for (int i = (x - 1) * 3 ; i <= (x - 1) * 3 + 2; i++) {
            for (int j = (y - 1) * 3; j <= (y - 1) * 3 + 2; j++) {
                palace[palaceRow][palaceCol] = this.data[i][j];
                palaceCol++;
            }
            palaceCol = 0;
            palaceRow++;
        }
        return palace;
    }

    public boolean rowContains(int row, int n) {
        for (int i : getRow(row)) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    public boolean colContains(int col, int n) {
        for (int i : getCol(col)) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    public boolean palaceContains(int x, int y, int n) {
        int[][] palace = this.getPalace(x, y);
        for (int[] row : palace) {
            for (int i : row) {
                if (i == n) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String parse(Sudoku sudoku) {
        return JSON.toJSONString(sudoku);
    }

    public static Sudoku toBoard(String s) {
        return JSONObject.parseObject(s, Sudoku.class);
    }


    public boolean isLegal() {
        return true;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
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
        sudoku.setData(data);


        String s = JSON.toJSONString(sudoku);
        Sudoku sudoku1 = JSONObject.parseObject(s, Sudoku.class);

        System.out.println(Arrays.toString(sudoku1.getRow(0)));

//        System.out.println(sudoku1);


    }

}
