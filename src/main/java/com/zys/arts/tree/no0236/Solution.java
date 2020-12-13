package com.zys.arts.tree.no0236;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 * @author zys
 * @date 2020-11-18 12:58
 */
public class Solution {
    LinkedList<List<TreeNode>> res = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root, p.val, new LinkedList<>());
        dfs(root, q.val, new LinkedList<>());
        TreeNode target = null;
        List<TreeNode> pList = res.poll();
        List<TreeNode> qList = res.poll();
        if (pList != null && qList != null) {
            int size = Math.min(pList.size(), qList.size());
            for (int i = 0; i < size; i++) {
                TreeNode p1 = pList.get(i);
                TreeNode q1 = qList.get(i);
                if (p1.val != q1.val) {
                    return target;
                }
                target = p1;
            }
        }
        return target;
    }

    public void dfs(TreeNode node, int val, LinkedList<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.offerLast(node);
        if (node.val == val) {
            res.add(new LinkedList<>(list));
        }
        dfs(node.left, val, list);
        dfs(node.right, val, list);
        list.removeLast();
    }
}
