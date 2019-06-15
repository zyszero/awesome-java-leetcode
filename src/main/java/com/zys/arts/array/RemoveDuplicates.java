package com.zys.arts.array;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/4/23 21:17
 * @Modified By:
 */
public class RemoveDuplicates {


    public int removeDuplicates1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int finalLength = 1, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                nums[finalLength] = nums[i];
                finalLength++;
            }
            prev = nums[i];

        }
        return finalLength;

    }

    /**
     * 假设 slow 为慢指针的下标，fast 为快指针的下标，因为 nums 数组是已经排好序的升序数组，
     * 所以当 nums[slow] = nums[fast]，我们让快指针前进一步，跳过重复的数据，即 fast++；若 nums[slow] != nums[fast]时，
     * 让慢指针前进一步，即 slow++，然后交换快指针与慢指针的值，将新数据替换掉重复数据，即 nums[slow] = nums[fast]；
     * 重复步骤直至快指针走到数组尾部，即 fast == nums.length时，输出结果 slow + 1，这就是去重后的数组长度了。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 当是空数组时，直接返回 0，边界条件
        if (nums.length == 0) {
            return 0;
        }
        // 慢指针
        int slow = 0;
        // fast 为 快指针
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
