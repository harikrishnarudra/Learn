package com.practice.leetcode.trees;

import com.practice.model.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2415. Reverse Odd Levels of Binary Tree
 *
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 *
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 * The level of a node is the number of edges along the path between it and the root node.
 *
 * Example 1:
 *
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 */

public class ReverseOddLevelNodeValues {

    // DFS approach
    public TreeNode reverseOddLevels(TreeNode root){
        reverse(root.left, root.right, 1);
        return root;
    }

    private void reverse(TreeNode left, TreeNode right, int level){
        if(left == null ||  right == null) return;
        if(level%2 == 1){
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
        reverse(left.left, right.right, level + 1);
        reverse(left.right, right.left, level + 1);
    }


}
