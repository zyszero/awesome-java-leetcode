package com.zys.arts.queue.offer59_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zys
 * @date 2020-12-18 11:46
 */
public class Solution_queue {
    /**
     * 利用辅助队列
     * 1. 队列中维持一个递减序列
     * 2. 队列头部则是当前区间的最大值
     * 3. 区间每往前移动一位，都需要比较移除的数，是不是队列头部的值，如果是，则移除队首
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) { // 未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            int val = nums[i - k];
            if (deque.peekFirst() == val) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numLen = nums.length;
        if (numLen == 0) {
            return new int[0];
        }
        int[] ans = new int[numLen - k + 1]; // 保存结果
        int left = 0; // 左指针
        int right = k - 1; // 右指针
        int max = -1; // 最大值指针

        while (right < numLen) {
            if (max < left) { // 更新最大值
                max = left;
                for (int i = left; i <= right; i++) {
                    max = nums[max] < nums[i] ? i : max;
                }
            } else {
                max = nums[max] < nums[right] ? right : max; // 更新最大值
            }
            ans[left] = nums[max];
            left++;
            right++;
        }
        return ans;
    }

}
