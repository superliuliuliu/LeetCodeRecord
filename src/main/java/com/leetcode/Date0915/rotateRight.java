package com.leetcode.Date0915;

// LEETCODE 61 向右移动n个节点
public class rotateRight {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head==null){
            return head;
        }
        // tail代表着尾节点
        int count = 0;
        ListNode tail = null;
        ListNode curr = head;
        while(curr != null){
            count++;
            tail = curr;
            curr = curr.next;
        }
        // tail是尾节点 构成循环链表
        tail.next = head;
        // 这时候首尾相连
        k = count - (k%count);
        // 遍历k次 head指向新的头结点 tail指向新的尾节点
        while (k > 0){
            tail = tail.next;
            head = head.next;
            k--;
        }
        tail.next = null;
        return head;
    }
}
