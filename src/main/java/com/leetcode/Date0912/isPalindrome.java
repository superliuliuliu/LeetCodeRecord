package com.leetcode.Date0912;

import com.leetcode.Date0821.ReverseList;

// leetcode 234判断一个链表是否是回文链表
// 需要注意题意  是是否是回文的 而不是最大回文字符子串
/**
 * 思路如下：
 * 先找到链表的中间节点（根据链表的节点个数区别）
 * 对中间节点的后半部分进行逆序处理
 * 比较前半部分和后半部分是否相同
 */
public class isPalindrome {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next == null){
            return true;
        }
        // 使用快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 注意链表的节点数
        while (fast != null && fast.next != null){
            // 当fast.next == null时 说明是奇数个节点 slow的位置为中间节点
            fast = fast.next.next;
            slow = slow.next;
            // 奇偶数的情况一样都是slow是起始点
        }
        ListNode temp = reverseList(slow);

        while (temp != null){
            if (head.val != temp.val){
                return false;
            }else{
                head = head.next;
                temp = temp.next;
            }
        }
        return true;
    }

    // 反转链表
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
