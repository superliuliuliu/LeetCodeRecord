package com.deadlock;

import java.util.Arrays;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 模拟两用户转账
 * @date 2019/11/13 0:08
 */
public class TransferMoney implements Runnable{

    private int flag;

    private static Account a = new Account(500);

    private static Account b = new Account(500);

    @Override
    public void run() {
        // 根据标志位不同 执行不同的逻辑代码
        if (flag == 0){
            transfer(a, b, 300);
        }else if (flag == 1){
            transfer(b, a, 300);
        }
    }

    private static void transfer(Account from, Account to, int money){
        // 锁定当前用户
        synchronized (from){
            // 锁定目标用户
            synchronized (to){
                if (from.balance - money < 0){
                    System.out.println("余额不足");
                    return;
                }else{
                    from.balance -= money;
                    to.balance += money;
                    System.out.println("转账成功 money = " + money);
                }
            }
        }
    }


    static class Account{
        private int balance;
        public Account(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r2.flag = 1;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.balance);
        System.out.println(b.balance);
    }
}
