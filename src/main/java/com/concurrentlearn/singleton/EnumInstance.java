package com.concurrentlearn.singleton;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 枚举类单例模式
 * @date 2019/12/7 10:24
 */
public enum EnumInstance {

    INSTANCE;

    private Object data;

    public static EnumInstance getInstance(){
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
