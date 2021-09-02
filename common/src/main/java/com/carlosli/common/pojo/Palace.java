package com.carlosli.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lijiancheng
 * @date 2021/9/1
 */

@Data
@AllArgsConstructor
public class Palace {

    // 行数
    public static final int ROWS = 3;
    // 列数
    public static final int COLUMNS = 3;
    // 数字
    private int[][] data;

    public Palace() {
        this.data = new int[ROWS][COLUMNS];
    }

    public void init(int init) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = init;
            }
        }
    }

    /**
     * 初始化
     */
    public void init() {
        this.init(0);
    }

    /**
     * 查询 行
     * @param row 行数
     * @return 该行数据
     */
    public int[] getRow(int row) {
        return data[row];
    }

    /**
     * 查询 列
     * @param column 列数
     * @return 列数据
     */
    public int[] getColumn(int column) {
        int[] col = new int[3];
        for (int i = 0; i < 3; i++) {
            col[i] = this.data[i][column];
        }
        return col;
    }

    public boolean contains(int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] == n) {
                    return true;
                }
            }
        }
        return false;
    }

}
