package com.zys.arts.tree.offer32;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zys
 * @date 2020-11-24 12:52
 */
public class Solution_dfs {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
