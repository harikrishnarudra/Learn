package com.practice.leetcode.contest;

import com.practice.model.ListNode;
import org.springframework.core.Ordered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RemoveNodes {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode root = head;

        while (root != null) {
            int val = root.val;
            list.add(val);
            root = root.next;
        }

        ListNode result = null;
        ListNode finalResult = null;
        int k = 0;
        while (head != null) {
            int val = head.val;
            boolean isAnyValueGreater = false;
            for (int i = k + 1; i < list.size(); i++) {
                if (list.get(i) > val) {
                    isAnyValueGreater = true;
                    break;
                }
            }
            if (!isAnyValueGreater) {
                if (result == null) {
                    result = head;
                    finalResult = result;
                } else {
                    result.next = head;
                    result = result.next;
                }
            }
            k++;
            head = head.next;
        }
        return finalResult;
    }
}
