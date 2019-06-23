package com.zys.arts.array;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author: zys
 * @date: 2019/6/21 23:15
 */
public class RotateImage {
    /**
     * 核心思路：
     * n × n 的矩阵
     * 由最外层到最里层，一层层依次进行旋转。
     * <p>
     * 可以观察的规律是
     * 1. 每层递进时，矩阵边长度都 -2
     * 2. a[x][x + offset] -> a[x + offset][y] -> a[y][y - offset] -> a[x][x + offset] 其中 offset 是偏移量，要满足 offset < 当前矩阵边长度 -1
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int x = 0;
        int y = matrix.length - 1;
        int currLength = matrix.length - 1;
        while (x < y) {
            int offset = 0;
            while (offset < currLength) {
                int topLeft = matrix[x][x + offset];
                matrix[x][x + offset] = matrix[y - offset][x];
                int topRight = matrix[x + offset][y];
                matrix[x + offset][y] = topLeft;
                int bottomRight = matrix[y][y - offset];
                matrix[y][y - offset] = topRight;
                matrix[y - offset][x] = bottomRight;
                ++offset;
            }
            ++x;
            --y;
            currLength -= 2;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2, 29, 20, 26, 16, 28}, {12, 27, 9, 25, 13, 21}, {32, 33, 32, 2, 28, 14}, {13, 14, 32, 27, 22, 26}, {33, 1, 20, 7, 21, 7}, {4, 24, 1, 6, 32, 34}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
