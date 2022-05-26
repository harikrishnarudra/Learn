package com.practice.leetcode.dfs;

import com.practice.model.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> finalRes = new ArrayList<>();
        Map<Integer, Map<Integer,List<Integer>>> resultMap = new TreeMap<>();
        if(root!=null){
            Map<Integer, List<Integer>> map = new TreeMap<>();
            map.put(0, new ArrayList<>());
            resultMap.put(0, map);
            dfs(root,  0, 0, resultMap);
        }
        for(Map.Entry entry : resultMap.entrySet()){
            Map<Integer, List<Integer>> value = (Map<Integer, List<Integer>>) entry.getValue();
            List<Integer> res = new ArrayList<>();
            for (Map.Entry lowerV : value.entrySet()) {
                res.addAll((Collection<? extends Integer>) lowerV.getValue());
            }
            finalRes.add(res);
        }
        return finalRes;
    }

    void dfs(TreeNode node, int columnOrder, int levelOrder, Map<Integer, Map<Integer, List<Integer>>> resultMap){
        int val = node.val;
        Map<Integer, List<Integer>> levelMap = resultMap.getOrDefault(columnOrder, new TreeMap<>());
        List<Integer> res = levelMap.getOrDefault(levelOrder, new ArrayList<>());
        res.add(val);
        levelMap.put(levelOrder, res);
        resultMap.put(columnOrder, levelMap);
        if(node.left!=null){
            dfs(node.left, columnOrder - 1, levelOrder + 1, resultMap);
        }
        if (node.right != null) {
            dfs(node.right,  columnOrder + 1, levelOrder + 1, resultMap);
        }
    }

    public static void main(String[] args) {
        VerticalOrder v = new VerticalOrder();
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;*/

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        left.left = new TreeNode(4);
        left.right = new TreeNode(0);
        left.right.right = new TreeNode(2);
        root.left = left;

        TreeNode right = new TreeNode(8);
        right.left = new TreeNode(1);
        right.right = new TreeNode(7);
        right.left.left = new TreeNode(5);
        root.right = right;


        System.out.println(v.verticalOrder(root));

    }
}
