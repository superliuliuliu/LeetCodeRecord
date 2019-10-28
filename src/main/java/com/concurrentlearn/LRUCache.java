package com.concurrentlearn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description My LRU缓存更新算法实现
 * @date 2019/10/28 18:32
 */
public class LRUCache<K, V> extends LinkedHashMap {

    // Redis内存的移除策略（当redis的内存之中积存了大量的过期未清除的键值对时） 定时清除策略加懒惰清除策略+内存淘汰机制
    // 缓存之中的最大容量
    private final int CACHE_SIZE;

    public LRUCache(int size){
        // true 代表按照访问顺序来排列 最近访问时间最短的的元素放在链表头部 最近访问时间间隔最长的元素内放置链表尾部
        // 0.75代表hashMap的填充度
        // Math.ceil(double x)方法返回的是大于x的最小数 相当于向上取整
        super((int) Math.ceil(size/0.75) + 1,0.75f, true);
        CACHE_SIZE = size;
    }

    // 是否移除链表尾部的元素 即链表中的元素数目超过了缓存之中的最大容量之时
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }
}

