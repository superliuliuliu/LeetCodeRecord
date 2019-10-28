package com.concurrentlearn.prodconmodel;


import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @description 生产者消费者模型 利用阻塞队列实现
 * @author liugaoyang
 * @date 2019/10/11 14:22
 * @version 1.0.0
 */
public class UseBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Date> storage = new LinkedBlockingQueue<>(10);
        Thread producer = new Producer(storage);
        Thread consumer = new Consumer(storage);

        producer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();
    }
}

/**
 *
 * @description 生产者模型
 * @author liugaoyang
 * @date 2019/10/11 14:23
 * @version 1.0.0
 */
class Producer extends Thread{

    private BlockingQueue<Date> storage;

    public Producer(BlockingQueue<Date> storage){
        this.storage = storage;
    }

    // 开始生产
    @Override
    public void run() {
        while(true) {
            try {
                // 一直在生产  把当前时间增加到队列之中
                Date date = new Date();
                storage.put(date);
                System.out.println("生产:" + date);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 *
 * @description 消费者模型
 * @author liugaoyang
 * @date 2019/10/11 14:23
 * @version 1.0.0
 */
class Consumer extends Thread{

    private BlockingQueue<Date> storage;

    public Consumer(BlockingQueue<Date> storage){
        this.storage = storage;
    }
    // 开始消费
    @Override
    public void run() {
        while(true){
            try {
                // 取出队列中的一个时间
                System.out.println("取出:"+ storage.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



