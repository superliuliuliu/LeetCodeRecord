package com.leetcode.Date0821;

// 两两交换链表节点
public class SwapPairs {
    // 定义链表的数据结构
    class ListNode{

        int val;

        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    // DummyNode 假的节点 用来定位链表的起始位置
    public ListNode swapPairs(ListNode head) {
        // 思路是什么 在写算法题之前要理清思路
        // 创建该节点的目的是为了便于定位最后的结果 作用类似于空的头节点
        ListNode result = new ListNode(0);
        result.next = head;
        // 当前节点
        ListNode curr = head;
        // pre代表待交换的起始节点的前一个节点
        ListNode pre = result;
        // 什么时候可以结束执行了？ 链表中没有元素了或者是链表中只有一个元素了
        while (curr != null && curr.next != null){
            // 保存节点信息防止修改丢失
            ListNode nextSwap = curr.next;
            curr.next = curr.next.next;
            nextSwap.next = curr;
            pre.next = nextSwap;
            // 前置节点复制
            pre = curr;
            curr = curr.next;
        }
        return result.next;
    }

    // 两两交换链表节点的递归解法
    public ListNode swapPairs2(ListNode head){

        // 确定终止条件
        if (head == null || head.next == null){
            return head;
        }
        // 确定返回值
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

//    public ListNode swapPairs(ListNode head) {
//        // 思路是什么 在写算法题之前要理清思路
//        // 创建该节点的目的是为了便于定位最后的结果 作用类似于空的头节点
//        ListNode result = new ListNode(0);
//        result.next = head;
//        // 当前节点
//        ListNode curr = head;
//        // pre代表待交换的起始节点的前一个节点
//        ListNode pre = result;
//        // 什么时候可以结束执行了？ 链表中没有元素了或者是链表中只有一个元素了
//        while (curr != null && curr.next != null){
//            // 保存节点信息防止修改丢失
//            ListNode next = curr.next;
//            ListNode nextSwap = curr.next.next;
//            next.next = curr;
//            curr.next = nextSwap;
//            pre.next = next;
//            pre = curr;
//            curr = nextSwap;
//        }
//        return result.next;
//    }
}
