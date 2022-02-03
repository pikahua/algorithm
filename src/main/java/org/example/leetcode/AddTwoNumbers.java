package org.example.leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode start = l3;
        int up = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + up;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + up;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + up;
                l1 = l1.next;
                l2 = l2.next;
            }

            up = sum / 10;
            sum = sum % 10;
            ListNode current = new ListNode();
            current.val = sum;
            l3.next = current;
            l3 = l3.next;
        }
        if (up > 0) {
            ListNode current = new ListNode();
            current.val = up;
            l3.next = current;
        }

        return start.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
