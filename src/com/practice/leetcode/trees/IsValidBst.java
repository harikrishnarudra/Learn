package com.practice.leetcode.trees;

import com.practice.model.TreeNode;

import java.util.Stack;

public class IsValidBst {

    public static boolean isValidBSTRecursive(TreeNode root) {
        return isValid(root, null, null);
    }

    public static boolean isValid(TreeNode root, Integer min, Integer max){
        if(root==null){
            return true;
        }
        if(min!=null && root.val <=min) return false;
        if(max!=null && root.val >=max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public static boolean isValidBSTInorderIterative(TreeNode root){
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre!=null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static TreeNode createTree(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(8);
        return root;
    }

    public static void printTree(TreeNode treeNode){
        if(treeNode!=null){
            System.out.println(treeNode.val);
            printTree(treeNode.left);
            printTree(treeNode.right);
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidBSTRecursive(createTree()));
        System.out.println(isValidBSTInorderIterative(createTree()));
    }
}
