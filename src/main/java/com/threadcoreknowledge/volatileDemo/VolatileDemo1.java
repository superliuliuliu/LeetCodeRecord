package com.threadcoreknowledge.volatileDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VolatileDemo1 implements Runnable {

    // volatile关键字修饰的标志位
    private volatile boolean flag = false;

    @Override
    public void run() {
        int num = 0;
        while(num<Integer.MAX_VALUE && !flag){
            if (num % 1000 == 0){
                System.out.println(num);
                try {
                    //睡眠1ms
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo1 demo1 = new VolatileDemo1();
        Thread t1 = new Thread(demo1);
        t1.start();
        Thread.sleep(5000);
        // 修改标志位以达到停止线程的目的
        demo1.flag = true;
        File file = null;
        FileWriter fw = null;
        String name = System.getProperty("user.dir") +System.getProperty("file.separator") + "a.txt";
        file = new File(name);
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file);
            for (int i = 1; i <= 500; i++){
                fw.write("test"+ i + "\n");
            }
            fw.flush();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
