package com.liugaoyang.xin.spring.ioc.overview.domain;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 用户
 * @date 2020/1/14 9:37
 */
public class User {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
