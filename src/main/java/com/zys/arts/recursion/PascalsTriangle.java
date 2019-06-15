package com.zys.arts.recursion;

import java.util.List;

import java.util.ArrayList;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/19 22:35
 * @Modified By:
 */
public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> getPascalsTriangle(int numRows) {
            List<List<Integer>> pascalsTriangle = new ArrayList<>();
            if (numRows == 0) {
                return pascalsTriangle;
            }
            // 首个数组一定是 1
            ArrayList<Integer> firstArray = new ArrayList<>();
            firstArray.add(1);
            pascalsTriangle.add(firstArray);
            for (int i = 1; i < numRows; i++) {
                List<Integer> temp = new ArrayList<>();
                // 上一个数组
                List<Integer> preList = pascalsTriangle.get(i - 1);
                // 每个数组头部元素总是 1
                temp.add(1);
                for (int j = 1; j < i; j++) {
                    temp.add(preList.get(j) + preList.get(j - 1));
                }
                // 每个数组尾部元素总是 1
                temp.add(1);
                pascalsTriangle.add(temp);
            }
            return pascalsTriangle;
        }
    }


    class Solution2 {
        public List<Integer> getRow(int numRows) {

            if (numRows == 0) {
                List<Integer> result = new ArrayList<>(numRows + 1);
                result.add(1);
                return result;
            }

            // 获取上一个数组，利用递归获取
            List<Integer> prevList = getRow(numRows - 1);
            // 从后往前遍历
            for (int i = numRows - 1; i > 0; i--) {
                // 即 curr[i] = prev[i] + prev[i - 1]
                prevList.set(i, prevList.get(i) + prevList.get(i - 1));
            }
            // 加入尾部元素 1
            prevList.add(1);
            return prevList;
        }
    }
}

