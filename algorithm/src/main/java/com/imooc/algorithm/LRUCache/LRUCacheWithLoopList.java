package com.imooc.algorithm.LRUCache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 基于双向链表实现的LRU缓存
 * @date 2020/2/10 22:57
 */
// 链表节点
class LNode<K,V> {

    public K key;
    public V value;
    // 双向链表节点  里面存储前驱节点 与后继节点的引用
    public LNode pre;
    public LNode next;

    public LNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.pre = null;
    }

    public LNode(){
        this.next = null;
        this.pre = null;
    }
}

// 链表类
class DoublyLinkedList<K, V>{

    private LNode<K,V> head;
    private LNode<K,V> tail;
    // 链表中元素的数量
    private int size;
    private int capacity;

    /**
     * getSize
     * @description 获取链表的长度
     * @return {@link Integer}
     * @author liugaoyang
     * @date 2020/3/5 22:26
     * @version 1.0.0
     */
    public int getSize() {
        return size;
    }

    // 构造函数
    public DoublyLinkedList() {
        this.head = new LNode<>();
        this.tail = new LNode<>();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    // 在链表头部添加节点
    public void addFirst(LNode node){
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
        size++;
    }

    // 在链表尾部删除节点 并返回该节点
    public LNode deleteLast(){
        if (tail.pre == head){
            return null;
        }
        LNode last = tail.pre;
        delete(last);
        return last;
    }

    // 删除节点 对应链表之中删除节点
    public void delete(LNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }
}

public class LRUCacheWithLoopList {
    Map<Integer, LNode<Integer, Integer>> map;
    private DoublyLinkedList<Integer, Integer> cache;
    private int capacity;
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).value;
        put(key, val);
        return val;

    }

    // 向缓存之中添加一个元素
    public void put(int key, int value) {
        LNode<Integer, Integer> node = new LNode<>(key, value);
        // 先看缓存之中是否拥有
        if (map.containsKey(key)){
            // 缓存之中拥有  就删除原节点 并重新插入到头部
            cache.delete(map.get(key));
            cache.addFirst(node);
            // 更新map
            map.put(key, node);
        }else{
            // 缓存之中没有该元素  需要新增
            if (cache.getSize() == this.capacity){
                // 容量不足
                LNode tail = cache.deleteLast();
                map.remove(tail.key);
            }
            // 容量不足则需要删除尾部节点
            cache.addFirst(node);
            map.put(key, node);
        }

    }


    public LRUCacheWithLoopList(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoublyLinkedList<>();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCacheWithLoopList cache = new LRUCacheWithLoopList( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
        String [] s = new String[10];
        System.out.println(s[0]);
        String a = "test";
        String b = new String("test");
        String c = new String(a);
        System.out.println(a==b);
        System.out.println(a==c);
        int[] test = new int[]{0,1,2,3,4,5,6,7,8};
        int[] result = Arrays.copyOfRange(test, 1, 5);

        System.out.println(result[3]);

    }
}
