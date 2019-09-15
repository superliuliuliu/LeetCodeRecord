package com.leetcode.Date0914;

// LEETCODE 83 链表  删除链表中重复元素
public class deleteDuplicates {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummyNode = new ListNode(-98764423);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode curr = head;
        while (curr != null){
            if (pre.val != curr.val){
                pre.next = curr;
                pre = pre.next;
            }
            curr = curr.next;
        }
        pre.next = null;
        return dummyNode.next;
    }
}
