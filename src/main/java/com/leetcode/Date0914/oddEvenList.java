package com.leetcode.Date0914;

// LEETCODE 328奇偶链表
public class oddEvenList {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode oddEvenList(ListNode head) {
        ListNode dummyNode1 = new ListNode(0);
        ListNode dummyNode2 = new ListNode(0);
        ListNode node1 = dummyNode1;// 用来存储奇数节点
        ListNode node2 = dummyNode2;// 用来存储偶数节点

        int count = 1;
        ListNode curr = head;
        while(curr != null){
            // 偶数的情况
            if (count % 2==0){
                node2.next = curr;
                node2 = curr;
            }// 奇数的情况
            else{
                node1.next = curr;
                node1 = curr;
            }
            curr = curr.next;
            count++;
        }
        // 拼接奇数偶数链表
        node1.next = dummyNode2.next;
        node2.next = null;
        return dummyNode1.next;

    }
}
