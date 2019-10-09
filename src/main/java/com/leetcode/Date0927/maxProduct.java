package com.leetcode.Date0927;

import java.util.*;

// leetcode 152 乘积的最大子序列
// 题目要求求最大的连续乘积值  如果数组中没有负数我们完全可以从头乘到尾部
// 但是数组中可能包含一个负数
// 我们首先声明一个值作为最大值 用它记录最大值 当出现一个新的最大值 我们用它和新的最大值比较
// 同时我们需要保存另外两个数 一个最大值 一个最小值 因为数组中存在负数 当出现负数时 最大值就会变成最小值 最小值反而会变成最大值
public class maxProduct {
    // 求乘积最大的  连续子序列的乘积

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 用来暂存最大值和最小值
        // 设置为1也是有用处的
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        Set<Integer> set = new HashSet<>();
        Stack<Integer> o = new Stack<>();

        return max;
    }

    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1){
            return true;
        }
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (record.get(arr[i]) == null){
                record.put(arr[i], 1);
            }else{
                record.put(arr[i], record.get(arr[i])+1);
            }
        }

        Set<Integer> set = new HashSet<>();

        for (Integer value: record.values()){
            if (set.contains(value)){
                return false;
            }else{
                set.add(value);
            }
        }
        return true;
    }

    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ;i++){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if (stack.size() == k){
                    // 凑满了k个重复数据清空
                    stack = new Stack<>();
                    s = sb.append(s.substring(i)).toString();
                    i = -1;
                    continue;
                }
                // 栈中没有k个元素
                else{
                    // 如果栈顶元素与遍历到的元素相等 则加入到栈中
                    if (stack.peek() == s.charAt(i)){
                        stack.push(s.charAt(i));

                    }
                    // 不是重复的元素 即栈顶元素不等于新进入的元素 则需要弹出原栈元素 并压入新的元素
                    else{
                        // 因为栈中只存储相等的元素
                        while(!stack.isEmpty()){
                            sb.append(stack.pop());
                        }
                        stack.push(s.charAt(i));
                    }
                }
            }
        }
        return sb.toString();
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            num[i] = s.charAt(i)>t.charAt(i)?s.charAt(i)-t.charAt(i): t.charAt(i)-s.charAt(i);
            System.out.println(num[i]);
        }
        // 快慢指针
        int slow = 0;
        int fast = 0;
        int max = Integer.MIN_VALUE;
        int cost = maxCost;
        while (fast < s.length()){
            if (cost - num[fast] >= 0){
                cost -= num[fast];
                fast++;
                max = (fast - slow) > max?(fast - slow): max;
            }else{
                // cost小于零
                max = (fast - slow) > max?(fast - slow): max;
                slow++;
                fast = slow;
                cost = maxCost;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        maxProduct one = new maxProduct();
        one.equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14);
    }


}
