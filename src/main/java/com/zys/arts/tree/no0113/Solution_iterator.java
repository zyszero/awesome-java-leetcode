package com.zys.arts.tree.no0113;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zys
 * @date 2020-11-17 11:06
 */
public class Solution_iterator {
    /**
     * 实现上有问题，卡壳了
     * 教训：卡壳5min，就应该放弃了，太浪费时间了
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        Deque<Integer> valQueue = new LinkedList<>();
        int curSum = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                curSum += cur.val;
                stack.push(cur);
                valQueue.offerLast(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();

            if (cur == null) {
                continue;
            }
            if (cur.left == null && cur.right == null) {
                if (curSum == sum) {
                    res.add(new LinkedList<>(valQueue));
                }
                curSum -= cur.val;
                valQueue.removeLast();
            } else if (cur.right == null) {
                valQueue.removeLast();
                curSum -= cur.val;
            }
            cur = cur.right;
        }
        return res;
    }
}
