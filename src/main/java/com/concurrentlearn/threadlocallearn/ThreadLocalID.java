package com.concurrentlearn.threadlocallearn;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @description
 * @author liugaoyang
 * @date 2019/10/9 9:11
 * @version 1.0.0
 */
public class ThreadLocalID {

    /*
     * 内部静态类
     * 使用方法 new
     */
    static class ThraedID{
        // 使用final修饰 表示具有不变性 即对象的地址不变
        static final AtomicLong nextId = new AtomicLong(0);
        // 本地线程存储
        static final ThreadLocal<Long> tl = ThreadLocal.withInitial(()->nextId.getAndIncrement());

        static Long get(){
            return tl.get();
        }
    }

    /*
    * 我们利用不同的线程调用ThreadID.get()方法得到的输出结果如下
    * 为什么是这个输出呢？不同的线程得到的结果不同，而相同的线程得到的结果相同
     */
    public static void main(String[] args) {
        // lamda表达式启动
        new Thread(()->{
            System.out.println(ThraedID.get());
            System.out.println(ThraedID.get());
        }).start();
        new Thread(()->{
            System.out.println(ThraedID.get());
            System.out.println(ThraedID.get());
        }).start();

        // 执行结果为：
        /*
        0
        1
        1
        2
        2
        * */
    }
}
