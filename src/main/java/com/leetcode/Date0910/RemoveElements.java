package com.leetcode.Date0910;

// 删除链表中的指定元素 leetcode 203
public class RemoveElements {
    // 删除链表汇总等于定值的节点
    public ListNode removeElements(ListNode head, int val) {
        // 利用dummyNode 伪节点来记录链表的起始位置
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        // 当前节点
        ListNode curr = head;
        while (curr != null){
            // 如果当前节点的值为val
            if (curr.val != val){
                node.next = curr;
                node = curr;
            }
            curr = curr.next;
        }
        node.next = null;
        return dummyNode.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
