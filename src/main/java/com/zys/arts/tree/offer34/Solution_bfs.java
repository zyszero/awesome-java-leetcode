package com.zys.arts.tree.offer34;

import java.util.*;

public class Solution_bfs {
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        map.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        queue.offer(root);
        valQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curVal = valQueue.poll();
            if (cur.left == null && cur.right == null) {
                if (sum == curVal) {
                    addPath(cur, res);
                }
            } else {
                if (cur.left != null) {
                    queue.offer(cur.left);
                    map.put(cur.left, cur);
                    valQueue.offer(curVal + cur.left.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    map.put(cur.right, cur);
                    valQueue.offer(curVal + cur.right.val);
                }
            }
        }
        return res;
    }

    private void addPath(TreeNode cur, List<List<Integer>> res) {
        LinkedList<Integer> tmp = new LinkedList<>();
        while (cur != null) {
            tmp.addFirst(cur.val);
            cur = map.get(cur);
        }
        if (tmp.size() > 0) {
            res.add(new ArrayList<>(tmp));
        }
    }
}
