package com.zys.arts.tree.no0113;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 *
 * @author zys
 * @date 2020-11-17 10:55
 */
public class Solution_recursion {
    private List<List<Integer>> res = new LinkedList<>();
    private Deque<Integer> queue = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    /**
     * dfs
     *
     * @param node
     */
    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        queue.addLast(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new LinkedList<>(queue));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        queue.removeLast();
    }


}
