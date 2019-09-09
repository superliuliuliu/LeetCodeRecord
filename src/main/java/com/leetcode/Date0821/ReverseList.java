package com.leetcode.Date0821;

// leetcode 206反转链表 难度：简单
public class ReverseList {

    // 定义链表的数据结构
    class ListNode{

        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    // 实现链表的反转  迭代的方法 时间复杂度 o(n)
    ListNode reverseList(ListNode head) {
        // 边界情况
        if (head == null){
            return null;
        }
        // 当前节点
        ListNode curr = head;
        // 前面节点
        ListNode pre = null;
        while (curr != null){
            // 因为要修改的是当前节点 所以保存一下当前节点的下一个节点 防止信息丢失
            ListNode next = curr.next;
            curr.next = pre;

            // 更新前节点
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 使用递归的求链表逆序的解法解法
    public ListNode reverseList2(ListNode head) {
        // 递归的终止条件
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;

    }


}

