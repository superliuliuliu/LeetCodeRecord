package com.leetcode.Date0825;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
          val = x;
        next = null;
    }
 }

 // LeetCode 142
 // 环形链表中 ，快慢指针解决环形入口问题：一个正常速度的指针从起点到入 等于该指针从第一次快慢指针相遇的位置到入口
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        ListNode first = null;

        while (fast != null && slow != null && fast.next != null){
            // 找到第一次相遇的节点位置
            if (fast == slow){
                first = fast;
                while(first != head){
                    first = first.next;
                    head = head.next;
                }
                return first;
            }
            // 没有找到 继续遍历
            fast = fast.next.next;
            slow = slow.next;

        }
        return null;

    }
}
