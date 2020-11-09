package com.zys.arts.tree.no0102;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zys
 * @date 2020-11-06 16:10
 */
public class Solution_1 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rootList = new ArrayList<>();
        if (root == null) {
            return rootList;
        }
        dfs(root, rootList, 1);
        return rootList;
    }

    /**
     * 深度优先遍历
     *
     * @param node
     * @param rootList
     * @param depth
     */
    public void dfs(TreeNode node, List<List<Integer>> rootList, int depth) {
        if (node == null) {
            return;
        }
        if (rootList.size() < depth) {
            rootList.add(new ArrayList<>());
        }
        rootList.get(depth - 1).add(node.val);
        dfs(node.left, rootList, depth + 1);
        dfs(node.right, rootList, depth + 1);
    }
}
