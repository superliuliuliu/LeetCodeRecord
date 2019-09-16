package com.leetcode.Date0915;

//leetcode 369给单链表加1
public class plusOne {

    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode plusOne(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        // 反转链表 head并未变
        dummyNode.next = reverseList(head);
        add(dummyNode.next);

        return reverseList(dummyNode.next);
    }

    public void add(ListNode one){
        if (one.val + 1 >= 10){
            one.val = (one.val + 1) % 10;
            if (one.next == null){
                ListNode temp = new ListNode(0);
                temp.next = null;
                one.next = temp;
            }
            add(one.next);
        }else{
            one.val += 1;
        }
    }

    public ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;
    }
}
