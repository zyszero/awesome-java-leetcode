package com.zys.arts.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: zys
 * @date: 2019/11/10 18:21
 * @see <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>
 */
public class MajorityElement {
    /**
     * 哈希表
     * 想法：
     * 我们知道出现次数最多的元素大于 [n/2]次，所以可以用哈希表来快速统计每个元素出现的次数。
     * <p>
     * 算法：
     * 我们使用哈希表来存储每个元素，然后用一个循环在线性时间内遍历 nums ，然后我们只需要返回有最大值的键
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }


    /**
     * 方法 3：排序
     * 详细解释查看：
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 方法 6：Boyer-Moore 投票算法
     * 详细解释查看：
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
        ;
    }
}
