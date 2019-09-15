package com.leetcode.Date0914;

// leetcode 160  寻找链表的相交节点
/*
* 利用链表长度差来解决这个问题
* 长链表走长度差个节点 然后长链表和短链表同时向前移动最终会走到相交节点
* 思路：首先同时遍历两链表 先遍历完的为短链表 遍历完后将其设置为长链表头
* 同理长链表遍历完后将其设置为短链表的头部 然后同时向前移动最终 相同的节点即为相交节点
*
*
*
* */
public class getIntersectionNode {

    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;

        while (ha != hb){
            ha = ha != null ? ha.next: headB;
            hb = hb != null ? hb.next: headA;
        }
        return ha;

    }
}
