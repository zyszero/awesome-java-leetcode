package com.zys.arts.array;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/5/21 0:00
 * @Modified By:
 */
public class Intersect {

    public static int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;

        }
        if (nums2.length == 0) {
            return nums2;
        }
        LinkedList<Integer> results = new LinkedList<>();
        // 1. 先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(nums1, k);
    }


    @SuppressWarnings("unchecked")
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 边界条件
        if (nums1.length == 0) {
            return nums1;

        }
        if (nums2.length == 0) {
            return nums2;
        }
        Map map = new HashMap<Integer, Integer>(16);
        List<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            // 判断 map 的 key 集合中是否有 a[i]，有，则 value + 1，无，则把这个值加入到map中
//            if (map.containsKey(i)) {
//                map.put(i, (int) map.get(i) + 1);
//            } else {
//                map.put(i, 1);
//            }
            // java 8 的写法
//            map.put(nums1[i], (int) map.getOrDefault(nums1[i], 0) + 1);
//            map.merge(nums1[i], 1, (a, b) -> (int) a + (int) b);
        }
        for (int i : nums2) {
            //判断 map 的 key 集合中是否有 b[j]，且对应的value 是否大于 0，若是，将 b[j] 加入到结果 list 中，并将 value 减一
            if (map.containsKey(i) && (int) map.get(i) > 0) {
                result.add(i);
                map.put(i, (int) map.get(i) - 1);
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }


}
