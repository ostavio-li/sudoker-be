package com.carlosli.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author lijiancheng
 * @date 2021/9/1
 */
public class Test {

    public static void main(String[] args) {

        int[] array = {7, 9, 14, 25};

        String s = "[7,9,14,25]";
        int[] ints = JSON.parseObject(s, int[].class);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
