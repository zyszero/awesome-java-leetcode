package com.zys.arts.tree.no0103;

import java.util.*;

public class Solution_iterator {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isFIFO = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                if (isFIFO){
                    list.addFirst(cur.val);
                }else {
                    list.addLast(cur.val);
                }
                if (cur.left != null){
                    queue.addLast(cur.left);
                }
                if (cur.right != null){
                    queue.addLast(cur.right);
                }
            }
            isFIFO = !isFIFO;
            if (!list.isEmpty()){
                res.add(list);
            }
        }
        return res;
    }
}
