package com.leetcode.Date0914;

// leetcode 82 删除链表中的重复元素2
public class deleteDuplicates2 {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        // 当链表是空的或者只含有一个节点时返回链表本身
        if (head == null || head.next == null){
            return head;
        }
        // 伪节点 同时要避免创建的伪节点与真正的头结点相同
        ListNode dummyNode = new ListNode(-921424);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode.next;
        while (fast != null){
            // 当该节点的值为重复时 向下走一个节点 直至fast指向重复节点的最后一个节点
            while (fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            // 代表没有出现重复节点
            if (slow.next == fast){
                slow = fast;
            }// 出现了重复节点
            else{
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummyNode.next;
    }
}
