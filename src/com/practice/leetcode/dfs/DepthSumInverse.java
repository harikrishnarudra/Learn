package com.practice.leetcode.dfs;

import com.practice.model.NestedInteger;

import java.util.List;

public class DepthSumInverse {
    class Solution {
        private int maxDepth = 1, mValue = 0, sum = 0;

        public int depthSumInverse(List<NestedInteger> nestedList) {
            doRecurse(nestedList, 1);
            return mValue * maxDepth + sum;
        }

        private void doRecurse(List<NestedInteger> nestedList, int depth) {
            for (NestedInteger item : nestedList) {
                if (item.isInteger()) {
                    mValue += item.getInteger();
                    sum += (1 - depth);
                    maxDepth = Math.max(depth, maxDepth);
                } else {
                    doRecurse(item.getList(), depth + 1);
                }
            }
        }
    }
}
