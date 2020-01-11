package com.concurrentlearn.hash;

import java.util.HashMap;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 验证HashMap扩容机制
 * @date 2019/12/13 16:56
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 14; i++){
            map.put("test"+ i, "test" + i);
        }
    }
}
