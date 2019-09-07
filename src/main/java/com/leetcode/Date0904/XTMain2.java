package com.leetcode.Date0904;

/**
 *
 * @description 携程笔试编程题第一题 LeetCode 86原题啊一摸一样 但是我还是没写出来
 * @author liugaoyang
 * @date 2019/9/5 13:16
 * @version 1.0.0
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class XTMain2 {

    // 最简单的思路 遍历一次链表将大于的节点提取出来 将小于的节点也提出出来 最后将上面两个链表链接起来输出的即为正确的结果
    public ListNode partition(ListNode head, int x) {
        // 当链表为空或者是链表中只有一个元素之时我们只需要返回它本身就好
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        // 生两个个伪头结点 防止遍历之后找不到头结点 无法返回链表
        ListNode dummyNode1 = new ListNode(0);
        ListNode dummyNode2 = new ListNode(0);
        ListNode node1 = dummyNode1;// 用来储存小于x的节点
        ListNode node2 = dummyNode2;// 用来存储大于x的节点
        // 遍历原有链表
        while (curr != null){
            // 判断节点值的大小关系
            if (curr.val < x){
                node1.next = curr;
                node1 = curr;
            }else{
                node2.next = curr;
                node2 = curr;
            }
            curr = curr.next;
        }
        // 注意遍历到最后的情况 要把尾节点的指针做相应的处理 否则会出现循环链表导致内存溢出
        node2.next = null;

        node1.next = dummyNode2.next;
        return dummyNode1.next;
    }

}
