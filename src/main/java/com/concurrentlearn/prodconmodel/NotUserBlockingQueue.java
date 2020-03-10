package com.concurrentlearn.prodconmodel;

import java.util.Date;
import java.util.LinkedList;

public class NotUserBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage(10);
        Thread producer = new Thread(new Producer1(storage));
        producer.start();
        Thread.sleep(2000);
        Thread consumer = new Thread(new Consumer1(storage));
        consumer.start();
    }
}

/**
 *
 * @description 生产者模型
 * @author liugaoyang
 * @date 2019/10/11 16:20
 * @version 1.0.0
 */
class Producer1 implements Runnable{

    private Storage storage;

    public Producer1(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        while(true){
            storage.put();
        }
    }
}

/**
 *
 * @description 消费者模型
 * @author liugaoyang
 * @date 2019/10/11 16:20
 * @version 1.0.0
 */
class Consumer1 implements Runnable{

    private Storage storage;

    public Consumer1(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        while(true){
            storage.take();
        }
    }
}

class Storage {
    // 仓库的最大容量
    private int MAXSIZE;
    private LinkedList<Date> storage;

    public Storage(int size){
        this.MAXSIZE = size;
        this.storage = new LinkedList<>();
    }


    public synchronized void put(){
        while (storage.size() == MAXSIZE){
            try {
                System.out.println("仓库已满无法生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("生产者进行生产");
        // 通知消费者可以消费了
        notify();
    }

    public synchronized void take(){
        while(storage.size() == 0){
            try {
                System.out.println("仓库为空无法消费");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费："+ storage.poll());
        // 通知生产者可以生产了
        notify();
    }


}

