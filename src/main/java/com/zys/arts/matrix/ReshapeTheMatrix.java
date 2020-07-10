package com.zys.arts.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 *
 * @author zys
 * @date 2020-07-10 10:03
 */
public class ReshapeTheMatrix {
    /**
     * 使用队列辅助
     * 时间复杂度：O(m * n) + O(m * n) = 2O(m * n) => O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape1(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length * nums.length != r * c) {
            return nums;
        }
        int y = nums.length, x = nums[0].length;

        Queue<Integer> queue = new ArrayDeque<>(r * c);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                queue.add(nums[i][j]);
            }
        }
        int[][] newNums = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newNums[i][j] = queue.remove();
            }
        }
        return newNums;
    }

    /**
     * 不使用额外的空间
     * 时间复杂度：O(m * n)
     * 空间复杂度度：O(1)
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape2(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length * nums.length != r * c) {
            return nums;
        }
        int y = nums.length, x = nums[0].length;
        int[][] newNums = new int[r][c];
        int col = 0, row = 0;
        for (int[] num : nums) {
            for (int j = 0; j < x; j++) {
                if (col == c) {
                    row++;
                    col = 0;
                }
                newNums[row][col] = num[j];
                if (col < c) {
                    col++;
                }
            }
        }
        return newNums;
    }

    /**
     * 除法和取模
     * 时间复杂度：O(m * n)
     * 空间复杂度度：O(1)
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length * nums.length != r * c) {
            return nums;
        }
        int x = nums[0].length;
        int count = 0;
        int[][] res = new int[r][c];
        for (int[] num : nums) {
            for (int i = 0; i < x; i++) {
                res[count / c][count % c] = num[i];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2, 3, 4}};
        int[][] ints = matrixReshape(test, 2, 2);
        System.out.println(ints);
    }
}
