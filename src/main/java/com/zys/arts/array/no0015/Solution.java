package com.zys.arts.array.no0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zys
 * @date 2020-12-02 20:09
 */
public class Solution {
    /**
     * 排序 + 双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        // 数组排序
        Arrays.sort(nums);
        // 随机选取一个值作为c值，因为a+b+c = 0 => c = a+b
        for (int i = 0; i < nums.length - 2; i++) {
            // 防止集合重复，由于数组排过序，是有有序的，只需要保证当前下标的值不等于上一个下标的值，则能保证不重复
            if (i == 0 || nums[i] != nums[i - 1]) {
                int c = nums[i];
                int head = i + 1;
                int tail = nums.length - 1;
                while (head < tail) {
                    int result = nums[head] + nums[tail] + c;
                    if (result == 0) {
                        List<Integer> list = Arrays.asList(c, nums[head], nums[tail]);
                        res.add(list);
                        // 优化，跳过重复的元素
                        while (head < tail && nums[head] == nums[head + 1]) {
                            head++;
                        }
                        // 优化，跳过重复的元素
                        while (head < tail && nums[tail] == nums[tail - 1]) {
                            tail--;
                        }
                        head++;
                        tail--;
                    } else if (result > 0) {
                        tail--;
                    } else {
                        head++;
                    }
                }
            }

        }
        return res;
    }
}
