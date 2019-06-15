package com.zys.arts.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/4/15 23:25
 * @Modified By:
 */
public class UniqueBTS {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1, n);
    }


    private List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> treeNodes = new ArrayList<>();

        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }


        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTreeNodes, rightTreeNodes;

            leftTreeNodes = genTrees(start, i - 1);
            rightTreeNodes = genTrees(i + 1, end);

            for (TreeNode leftTreeNode :
                    leftTreeNodes) {
                for (TreeNode rightTreeNode :
                        rightTreeNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeNode;
                    root.right = rightTreeNode;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }


}
