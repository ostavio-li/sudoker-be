package com.carlosli.common.pojo;

import com.sun.org.apache.bcel.internal.generic.ArrayElementValueGen;
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
public class Board implements Serializable {

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;

    private static final long serialVersionUID = -6533099186502639008L;

    int[][] data;

    public Board() {
        this.data = new int[9][9];
    }

    public void init(int init) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.data[i][j] = init;
            }
        }
    }

    public void init() {
        this.init(0);
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

    public boolean isLegal() {
        return true;
    }

    public static void main(String[] args) {
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

        int[] row = board.getRow(3);
        int[] col = board.getCol(4);
        boolean b = board.palaceContains(3, 2, 4);


        System.out.println(b);


    }

}
