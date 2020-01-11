package com.concurrentlearn.threadlocallearn;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 存储用户信息的ThreadLocal实现
 * @date 2020/1/11 11:36
 */
public class ThreadLocalStorageInfo {
    public static void main(String[] args) {
        Service1 service1 = new Service1();
        service1.process();
        Service2 service2 = new Service2();
        service2.print();
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

class Service1{

    public void process(){
        User user = new User("刘高阳");
        UserContextHolder.set(user);
    }

}

class Service2{
    public void print(){
        System.out.println(UserContextHolder.get().name);
    }
}

class UserContextHolder{
    private static ThreadLocal<User> holder = new ThreadLocal<>();

    // 设置用户
    public static void set(User user){
        holder.set(user);
    }

    // 获取用户
    public static User get(){
        return holder.get();
    }
}
