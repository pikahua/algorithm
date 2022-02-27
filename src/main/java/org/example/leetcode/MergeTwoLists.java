package org.example.leetcode;

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null){
            ListNode listNode = new ListNode();
            if(list1.val <= list2.val){
                listNode.val = list1.val;
                list1 = list1.next;
            }else{
                listNode.val = list2.val;
                list2 = list2.next;
            }
            cur.next = listNode;
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
