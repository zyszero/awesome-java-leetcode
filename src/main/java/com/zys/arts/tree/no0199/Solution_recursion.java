package com.zys.arts.tree.no0199;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 *        1            <---
 *      /   \
 *     2     3         <---
 *      \     \
 *       5     4       <---
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 */
public class Solution_recursion {
    /**
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        return list;
    }
}
