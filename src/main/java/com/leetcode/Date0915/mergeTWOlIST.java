package com.leetcode.Date0915;

//LEETCODE 21合并两个有序链表
public class mergeTWOlIST {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;

            }
        }
        if (l1 == null){
            curr.next = l2;
        }else{
            curr.next = l1;
        }
        return dummyNode.next;
    }
}
