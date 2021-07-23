package com.practice.leetcode.top100;

import com.practice.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        if (root.left != null && root.right == null) {
            return 1+maxDepth(root.left);
        }
        if (root.left == null && root.right != null) {
            return 1 + maxDepth(root.right);
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBFS(TreeNode root){
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                TreeNode element = queue.poll();
                if(element.left!=null){
                    queue.add(element.left);
                }
                if (element.right != null) {
                    queue.add(element.right);
                }
            }
            result++;
        }
        return result;
    }

    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int result = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int temp = value.pop();
            result = Math.max(temp,result);
            if(node.left!=null){
                stack.push(node.left);
                value.push(temp+1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        maxDepthOfBinaryTree.maxDepth(null);
    }
}
