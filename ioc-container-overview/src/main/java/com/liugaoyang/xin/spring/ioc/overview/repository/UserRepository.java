package com.liugaoyang.xin.spring.ioc.overview.repository;

import com.liugaoyang.xin.spring.ioc.overview.domain.User;

import java.util.Collection;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 用户信息仓库
 * @date 2020/1/14 19:59
 */
public class UserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
