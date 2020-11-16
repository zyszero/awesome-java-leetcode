package com.zys.arts.tree.no0199;

import java.util.ArrayList;
import java.util.List;

public class Solution_recursion {

    private int maxDepth = Integer.MIN_VALUE;

    /**
     * DFS
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        depth(root, res, 0);
        return res;
    }

    private void depth(TreeNode node, List<Integer> res, int depth) {
        if (node == null) {
            return;
        }
        if (maxDepth < depth) {
            res.add(node.val);
            maxDepth = depth;
        }
        depth(node.right, res, depth + 1);
        depth(node.left, res, depth + 1);
    }
}
