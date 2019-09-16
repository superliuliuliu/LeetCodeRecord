package com.leetcode.Date0915;

import java.util.Stack;

// leetcode 445
public class addTwoNumbers {
    class ListNode{
        int val;

        // 下一个节点
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        

        while (l1 != null){
            stack1.push(l1.val);
        }
        while (l2 != null){
            stack2.push(l2.val);
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = null;
        // 只要有一个栈不为空 就继续
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            // 栈1为空的情况
            ListNode node = new ListNode(0);
            if (stack1.isEmpty()){
                int val = stack2.pop() + add;
                add = 0;
                if (val >= 10){
                    node.val = val % 10;
                    add = 1;
                    // 进位
                }else{
                    node.val = val;
                }
            }// 栈2为空的情况
            else if(stack2.isEmpty()){
                int val = stack1.pop() + add;
                add = 0;
                if (val >= 10){
                    node.val = val % 10;
                    add = 1;
                    // 进位
                }else{
                    node.val = val;
                }
            }// 栈1和栈2都不为空的情况
            else{
                int val = stack1.pop() + stack2.pop() + add;
                // 将add置为0
                add = 0;
                if (val >= 10){
                    node.val = val % 10;
                    add = 1;
                    // 进位
                }else{
                    node.val = val;
                }
            }
            node.next = dummyNode.next;
            dummyNode.next = node;
        }
        return dummyNode.next;

    }

}
