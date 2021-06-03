package com.test.hackerrank.thirtyDaysCode;

import java.util.Objects;
import java.util.Scanner;

class NodeLL {
    int data;
    NodeLL next;

    NodeLL(int d) {
        data = d;
        next = null;
    }

}
public class RemoveDupsLL {

    public static NodeLL removeDuplicates(NodeLL head) {
        //Write your code here
        NodeLL q = head;
        if(q==null){
            return q;
        }
        int prevData = q.data;
        while (q.next!=null){
            if(prevData == q.next.data){
                q.next = q.next.next;
            }
            else if (q.next != null){
                q = q.next;
                prevData = q.data;
            }
        }
        return head;
    }

    public static NodeLL insert(NodeLL head, int data) {
        NodeLL p = new NodeLL(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            NodeLL start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;
        }
        return head;
    }

    public static void display(NodeLL head) {
        NodeLL start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        NodeLL head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
    }
}
