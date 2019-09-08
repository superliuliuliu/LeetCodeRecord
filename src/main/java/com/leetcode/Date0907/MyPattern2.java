package com.leetcode.Date0907;

public class MyPattern2 {

    // 使用回溯算法求解此正则表达式匹配问题
    private boolean matched;

    public boolean isMatch(String s, String p) {
        matched = false;
        // 当字符串s和正则表达式p为空时直接返回false
        // 当正则表达式的第一个字符为'*'时 直接返回false
        if (s.isEmpty() || p.isEmpty() || p.charAt(0) == '*'){
            return matched;
        }
        // 递归 从字符串的第一个字符 正则表达式的第一个字符开始进行匹配
        getResult(0, 0, s, p);
        return matched;
    }

    // si代表匹配字符串的位置 pi代表正则表达式的字符位置

    private void getResult(int si, int pi, String s, String p){
        // 若已经匹配直接返回true
        if (matched){
            return;
        }
        // 如果正则表达式字符已经匹配完成 此时需要返回匹配结果
        if (pi == p.length()){
            // 这是字符串也匹配完成的话返回true
            if (si == s.length()){
                matched = true;
            }
            return;
        }
        // 分为三种情况
        // 正则表达式的字符为 '.'只能匹配任意的单个字符
        // 正则表达式的字符为 '*' 匹配0个或者任意多个前面的字符
        // 正则表达式是非通配符 这样只有p.charAt(pi) == t.charAt(ti)才可以继续匹配
        if (p.charAt(pi) == '.'){
            getResult(si + 1, pi + 1, s, p);
        }else if (p.charAt(pi) == '*'){
            // 正则表达式的字符为 '*'我们应该如何处理 匹配0个或者任意多个*号前面的字符 *号前面的字符为p[pi-1]
            for (int i = 0; i <= s.length() - si; i++){
                //匹配0或任意个字符
                getResult(si + i,pi + 1, s, p);
            }

        }// 正则表达式字符是非统配字符的情况下
        else {
            // 如果非通配字符与字符串中的字符相等 则进入下一个字符的匹配
            if (p.charAt(pi) == s.charAt(si)){
                getResult(si + 1, pi + 1, s, p);
            }
            // 如果非通配符不等于字符串中的字符
            else{
                if (p.charAt(pi + 1) == '*'){
                    getResult(si, pi + 1, s, p);
                }else{
                    return;
                }
            }
        }
    }
}
