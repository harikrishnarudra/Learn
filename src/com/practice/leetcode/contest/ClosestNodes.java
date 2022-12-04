package com.practice.leetcode.contest;

import com.practice.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodes {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            final List<Integer> integers = List.of(-1, -1);
            for(int i=0;i<queries.size();i++){
                result.add(integers);
            }
        }
        for(int i=0;i<queries.size();i++){
            int ele = queries.get(i);
            int rootVal = root.val;
            List<Integer> eleResult;
            if(rootVal > ele){
                eleResult = findEle(-1, ele, rootVal, root.left);
            }else{
                eleResult = findEle(rootVal, ele, -1, root.right);
            }
            result.add(eleResult);
        }
        return result;
    }

    private List<Integer> findEle(int low, int num, int high, TreeNode root){
        if(root == null){
            return List.of(low, high);
        }
        if(root.val == num){
            return List.of(num, num);
        }
        if(num > root.val && low < root.val){
            return findEle(root.val, num,high, root.right);
        }
        if (num < root.val && high > root.val) {
            return findEle(low, num, root.val, root.left);
        }
        return List.of(low, high);
    }


    //[9,6,14,null,null,13,20,12]
    //[19,10,9,17,19,6,10,19,13,6]
}
