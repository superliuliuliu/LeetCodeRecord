package com.liugaoyang.xin.spring.ioc.overview.domain;

import com.liugaoyang.xin.spring.ioc.overview.annotation.Super;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 超级用户
 * @date 2020/1/14 11:03
 */
@Super
public class SuperUser extends User {

    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}' + super.toString();
    }
}
