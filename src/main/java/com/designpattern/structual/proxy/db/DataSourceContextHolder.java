package com.designpattern.structual.proxy.db;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 线程的数据源上下文信息
 * @date 2019/12/8 23:37
 */
public class DataSourceContextHolder {
    // 存储Spring dataSource的bean name用作分库分表使用
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    // 设置bean name
    public static void setDBtype(String dBtype){
        CONTEXT_HOLDER.set(dBtype);
    }

    // 获取db name
    public static String getDBtype(){
        return (String) CONTEXT_HOLDER.get();
    }

    // 清除ThreadLocal中的数据
    public static void clear(){
        CONTEXT_HOLDER.remove();
    }
}
