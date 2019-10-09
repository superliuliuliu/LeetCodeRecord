package com.leetcode.Date0929;

import javafx.util.Pair;

import java.util.Stack;

/*
输入：s = "deeedbbcccbdaa", k = 3
输出："aa"
解释：
先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
再删除 "bbb"，得到 "dddaa"
最后删除 "ddd"，得到 "aa"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class removeDuplicates {

    class Node {
        Character c;
        Integer val;

        public Node(Character c, Integer val){
            this.c = c;
            this.val = val;
        }

    }

    public String removeDuplicates(String s, int k) {
        Stack<Node>  nodeStack =  new Stack<>();
        // 声明一个栈来存储字符以及其对应的次数
        for (int i = 0; i < s.length(); i++){
            // 如果栈为空 或者栈顶元素有值 且字符相等
            if (!nodeStack.isEmpty() && nodeStack.peek().c == s.charAt(i)){
                // 计数器加1
                nodeStack.peek().val++;
            }else{
                nodeStack.push(new Node(s.charAt(i), 1));
            }
            if (nodeStack.peek().val == k){
                // 如果计数器为k则弹出元素
                nodeStack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!nodeStack.isEmpty()){
            while (nodeStack.peek().val != 0){
                sb.append(nodeStack.peek().c);
                nodeStack.peek().val--;
            }
            if (nodeStack.peek().val == 0){
                nodeStack.pop();
            }
        }
        return sb.reverse().toString();
    }
}
