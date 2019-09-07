package com.leetcode.Date0825;

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 尝试使用递归解法
        // 递归的终止条件  当链表的剩余节点数小于k时（包括空的情况）
        // 一级递归返回值是直接返回该节点
        // 每一级递归其实执行的是反转链表操作
        int length = k;
        // 首先查看当前节点后是否有k个节点
        ListNode curr = head;
        // 记录一下可翻转区间的最后一个节点
        ListNode end = null;
        while (curr != null && length > 0){
            end = curr;
            length--;
            curr = curr.next;
        }
        // 说明剩下的节点数不足以反转 直接返回原链表
        if (length > 0){
            return head;
        }
        // 每一级递归的返回值 就是经过操作的头结点的位置
        end.next = reverseKGroup(end.next, k);
        // 开始执行递归内容 即链表反序 头结点为head  尾节点为end
        // 未到结束位置
        while(head != end){
            ListNode pre = head;
            head = head.next;
            pre.next = end.next;
            end.next = pre;
        }
        return end;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode result = reverseKGroup(head, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
