package com.zys.arts.array;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/5/3 23:35
 * @Modified By:
 */
public class RotateArray  {

    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = nums[0];
                nums[0] = temp;
            }
        }

    }


    /**
     * 仔细观察 Example ，我们可以发现一个事实，旋转数组 K 次，K 个元素从数组后端挪动到前端，其余元素从前端挪到后端。
     * 在这种方法中，我们首先翻转数组，然后再次翻转数组前 k 个元素，最后翻转 n - k 个元素，即其余的元素，n 为数组长度；这样就能得出答案。
     * 例子：
     *
     * ```java
     * 原始数组                           : 1 2 3 4 5 6 7
     * 首先翻转整个数组                    : 7 6 5 4 3 2 1
     * 其次翻转数组前 k 个元素             : 5 6 7 4 3 2 1
     * 最后翻转数组后 n - k 个元素         :5 6 7 1 2 3 4 --> Result
     * ```
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 翻转整个数组
        reverse(nums, 0, nums.length - 1);
        // 翻转数组前 k 个元素
        reverse(nums, 0, k - 1);
        // 翻转数组后 n - k 个元素
        reverse(nums, k, nums.length - 1);
    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(2 % 3);
    }
}
