package com.zys.arts.tree.no0113;

import java.util.*;

/**
 * @author zys
 * @date 2020-11-18 10:45
 */
public class Solution_BFS {
    private List<List<Integer>> res = new LinkedList<>();

    /**
     * 用于回溯，记录每个节点的父节点
     * key - 当前节点
     * value - 当前节点的父节点
     */
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    /**
     * 利用Queue来实现二叉树的层次遍历，即中序遍历
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        queue.offer(root);
        map.put(root, null);
        valQueue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer rec = valQueue.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                    valQueue.offer(rec);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    valQueue.offer(rec);
                    map.put(node.right, node);
                }
            }
        }
        return res;
    }

    private void getPath(TreeNode node) {
        Deque<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.addFirst(node.val);
            node = map.get(node);
        }
        res.add(new LinkedList<>(temp));
    }
}
