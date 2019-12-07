package com.concurrentlearn.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 容器单例
 * @date 2019/12/7 13:14
 */
public class ContainerSingleton {
    // HashMap虽然不是线程安全的类 但是如果我们初始化这个容器时就完成了单例的填充 那么是没有问题的
    private static Map<String, Object> instanceMap = new HashMap<>();

    public static void putInstance(String key, Object instance){
        if (StringUtils.isNoneBlank(key) && instance != null){
            if (!instanceMap.containsKey(key)){
                instanceMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key){
        return instanceMap.get(key);
    }

    private ContainerSingleton(){

    }
}
