package com.carlosli.common.pojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author lijiancheng
 * @date 2021/9/1
 */
class PalaceTest {

    @Test
    void getRow() {
        Palace palace = new Palace();
        int[][] data = new int[][]{{4, 5, 1}, {3, 0, 9}, {2, 7, 8}};
        palace.setData(data);
        int[] row = palace.getRow(1);
        System.out.println(Arrays.toString(row));
    }

    @Test
    void getColumn() {
        Palace palace = new Palace();
        int[][] data = new int[][]{{4, 5, 1}, {3, 0, 9}, {2, 7, 8}};
        palace.setData(data);
        System.out.println(Arrays.toString(palace.getColumn(2)));
    }

    @Test
    void contains() {
        Palace palace = new Palace();
        int[][] data = new int[][]{{4, 5, 1}, {3, 0, 9}, {2, 7, 8}};
        palace.setData(data);
        boolean contains = palace.contains(3);
    }
}