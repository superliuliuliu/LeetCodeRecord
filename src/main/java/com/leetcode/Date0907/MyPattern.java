package com.leetcode.Date0907;

// 使用回溯算法构建一个简单的正则表达式匹配程序
// * 可以匹配0个或者多个任意字符 ？可以匹配0个或者一个任意字符
public class MyPattern {

    private boolean matched;

    // text是待匹配的文本 pattern是正则表达式
    public boolean match(char[] text, char[] pattern){
        // 默认是不匹配的
        matched = false;
        // 使用回溯算法进行字符串匹配
        rmatch(0, 0, text, pattern);
        return matched;
    }

    // 还是讲问题分成n个阶段 每个阶段用来考察正则表达式中的一个字符
    private void rmatch(int ti, int pi, char[] text, char[] pattern){
        // 如果已经匹配了那么返回即可
        if (matched) return;
        // 正则表达式到结尾了
        if (pi == pattern.length){
            // 文本内容也到结尾了
            if (ti == text.length){
                matched = true;
            }
            return;
        }
        // 匹配上的是'*'
        if (pattern[pi] == '*'){
            for (int i = 0; i <= text.length - ti; i++){
                // 因为*可能匹配的是大于等于0个任意字符
                rmatch(ti + i, pi + 1, text, pattern);
            }
        }else if (pattern[pi] == '?'){
            // ？匹配0或者1个任意字符
            // 匹配0个
            rmatch(ti, pi + 1, text, pattern);
            // 匹配1个
            rmatch(ti + 1, pi + 1, text, pattern);
        }else {
            // 非通配符匹配 需要相等才会进行下一个字符的匹配工作
            if (text[ti] == pattern[pi]){
                rmatch(ti + 1, pi + 1, text, pattern);
            }
            String s;

        }
    }

    public static void main(String[] args) {
        char[] text = new char[]{'a','b','c'};
        char[] pattern = new char[]{'a', 'b', '*'};
        System.out.println(new MyPattern().match(text, pattern));

    }
}
