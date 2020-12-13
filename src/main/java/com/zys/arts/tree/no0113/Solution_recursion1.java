package com.zys.arts.tree.no0113;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zys
 * @date 2020-11-17 11:59
 */
public class Solution_recursion1 {
    private List<List<Integer>> res = new LinkedList<>();
    private Deque<Integer> queue = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0);
        return res;
    }

    public void dfs(TreeNode node, int sum, int curSum) {
        if (node == null) {
            return;
        }
        curSum += node.val;
        queue.addLast(node.val);
        if (node.left == null && node.right == null) {
            if (sum == curSum) {
                res.add(new LinkedList<>(queue));
            }
        }
        dfs(node.left, sum, curSum);
        dfs(node.right, sum, curSum);
        queue.removeLast();
    }
}
