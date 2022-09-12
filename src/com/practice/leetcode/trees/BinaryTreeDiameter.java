package com.practice.leetcode.trees;

import com.practice.model.TreeNode;

import java.util.List;

public class BinaryTreeDiameter {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        doRecurse(root);
        return max;
    }

    public int doRecurse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doRecurse(root.left);
        int right = doRecurse(root.right);
        max = Math.max((left + right), max);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        BinaryTreeDiameter b = new BinaryTreeDiameter();
        System.out.println(b.diameterOfBinaryTree(new TreeNode()));
    }
}
