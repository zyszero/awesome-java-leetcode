package com.zys.arts.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/5/5 17:09
 * @Modified By:
 */
public class ContainsDuplicate {

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {

        long count = Arrays.stream(nums).distinct().count();
        return nums.length == count;
    }
}
