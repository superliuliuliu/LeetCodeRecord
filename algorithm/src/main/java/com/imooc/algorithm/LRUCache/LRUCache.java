package com.imooc.algorithm.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description My LRU缓存更新算法实现
 * @date 2019/10/28 18:32
 */
public class LRUCache<K, V> extends LinkedHashMap {

    private final int SIZE;

    // 构造函数
    public LRUCache(int SIZE) {
        super((int) Math.ceil(SIZE/0.75) + 1, 0.75f, true);
        this.SIZE = SIZE;
    }

    // 何时删除最近最久未使用的元素
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 当链表之中的元素数量大于指定的数量时
        return size() > SIZE;
    }
}



