package com.zys.arts.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author zys
 * @date 2020-07-09 11:47
 */
public class ContainerWithMostWater {
    /**
     * 思路：双指针 + 最大面积是由较短板决定的
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException();
        }
        int maxArea = 0, s = 0, e = height.length - 1;
        while (s < e) {
            maxArea = Math.max(maxArea, Math.min(height[s], height[e]) * (e - s));
            if (height[s] <= height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return maxArea;
    }

}
