package com.leetcode.Date0915;

// Leetcode 23 合并k个排序的链表
// 采用分而治之的思想 将k个链表的集合分为两个部分
//然后利用递归的思想，对每一部分调用本身得到一个合并的链表  最后将这两个链表合并即可得到一个最终合并的链表
public class MergeKLists {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge2Lists(lists[0], lists[1]);
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        ListNode[] l2 = new ListNode[lists.length - mid];
        // 使用递归加分治的算法 将k个链表的集合分为两个部分
        for (int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }
        for (int i = 0; i < lists.length - mid; i++){
            l2[i] = lists[mid + i];
        }
        //
        return merge2Lists(mergeKLists(l1), mergeKLists(l2));
    }



    // 合并两个有序链表
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (l1 != null && l2 != null){
            // 当l1的值小于等于l2的值时
            if (l1.val <= l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 == null){
            curr.next = l2;
        }
        if (l2 == null){
            curr.next = l1;
        }
        return dummyNode.next;
    }
}
