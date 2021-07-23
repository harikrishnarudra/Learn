package com.practice.leetcode.top100;

import com.practice.model.ListNode;

import java.util.List;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Example 1:
 *
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rear = l1;
        ListNode head = l2;
        if (l1 != null && l2 != null && l1.val < l2.val) {
            head = l1;
            rear = l2;
        }

        ListNode result = head;
        ListNode prev = head;
        while (rear != null && head != null) {
            if (head.val < rear.val) {
                prev = head;
                head = head.next;
            } else {
                if (prev == head) {
                    head = prev.next;
                }
                prev.next = rear;
                rear = rear.next;
                prev = prev.next;
                prev.next = head;
            }
        }
        if (rear != null && head == null) {
            if (prev == null) {
                result = rear;
            } else {
                prev.next = rear;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
