package com.leetcode.Date0916;


import java.util.Arrays;

// leetcode 725分隔链表
public class splitListToParts {

    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        // 结果集合
        ListNode[] result = new ListNode[k];
        if (root == null){
            return result;
        }
        // 首先遍历链表得到链表的长度
        ListNode curr = root;
        int length = 0;
        while (curr != null){
            curr = curr.next;
            length++;
        }
        // 每一段分配的平均值
        int ava = length / k;
        // 剩下的未分配的节点数
        int remain = length % k;
        // 新建一个数组用来记录每个部分应该存储的节点数
        int[] count = new int[k];
        Arrays.fill(count, ava);
        for(int i = 0; i < k && remain > 0; i++){
            count[i]++;
            remain--;
        }
        // 重新指向头结点
        curr = root;
        ListNode temp = root;
        // 得到的count数组中记录着每个部分应该存储的节点数
        for(int i = 0; i < k; i++){
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = temp;
            curr = temp;
            if (count[i] == 0){
                dummyNode.next = null;
            }
            while(count[i] > 0){
                if (count[i] == 1){
                    temp = curr.next;
                    curr.next = null;
                    count[i]--;
                }else{
                    count[i]--;
                    curr = curr.next;
                }
            }
            result[i] = dummyNode.next;
        }
        return result;
    }
}
