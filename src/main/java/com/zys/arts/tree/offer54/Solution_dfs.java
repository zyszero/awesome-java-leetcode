package com.zys.arts.tree.offer54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zys
 * @date 2020-11-24 10:14
 */
public class Solution_dfs {

    /**
     * 中序遍历 - 变体
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.right, list);
        list.add(node.val);
        dfs(node.left, list);
    }
}
