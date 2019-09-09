package com.leetcode.Date0909;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.letterCombinations("23");

    }
}
class Solution {

    private List<String> result;

    private Map<Character, String> store;

    // 返回电话号码代表的所有字母的组合
    public List<String> letterCombinations(String digits) {
        store = new HashMap<Character, String>();
        result = new ArrayList<>();
        if (digits.isEmpty()){
            return result;
        }
        store.put('2', "abc");
        store.put('3', "def");
        store.put('4', "ghi");
        store.put('5', "jkl");
        store.put('6', "mno");
        store.put('7', "pqrs");
        store.put('8', "tuv");
        store.put('9', "wxyz");
        getLetter(0, digits, 0, new StringBuilder());
        return result;
    }

    // order代表第几个数字 start代表从第几个字母开始
    private void getLetter(int order, String digits, int start, StringBuilder subset){
        // 已经遍历完成
        if (order == digits.length()){
            // result.add()
            result.add(subset.toString());
            return;
        }
        // 还没有遍历完成
        String str = store.get(digits.charAt(order));
        for (int i = start; i < str.length(); i++){
            subset.append(str.charAt(i));
            getLetter(order + 1, digits, 0, subset);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
