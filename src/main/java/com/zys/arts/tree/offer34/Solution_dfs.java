package com.zys.arts.tree.offer34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution_dfs {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        list.addLast(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res.add(new ArrayList<>(list));
            }
        }
        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
        list.pollLast();
    }
}
