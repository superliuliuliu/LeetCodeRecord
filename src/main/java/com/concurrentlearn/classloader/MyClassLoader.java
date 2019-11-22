package com.concurrentlearn.classloader;

import java.io.*;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 自定义类加载器
 * @date 2019/11/1 9:48
 */
public class MyClassLoader extends ClassLoader{

    /** 需要加载的类的位置 */
    private String path;

    /** 类加载器的名称 */
    private String name;

    /** 构造函数 */
    public MyClassLoader(String path, String name){
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 需要加载的class文件的名称
        String name1 = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            // 从文件之中读取字节码文件
            in = new FileInputStream(new File(name1));
            out = new ByteArrayOutputStream();
            int i = 0;
            // 写入到输出流之中
            while ((i = in.read())!= -1){
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 将二进制字节流加载为类对象
        return defineClass(name, out.toByteArray(), 0, out.toByteArray().length);
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("xxx", "lgyClassLoader");
        try {
            // 加载一个类
            Class c = myClassLoader.loadClass("lgy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
