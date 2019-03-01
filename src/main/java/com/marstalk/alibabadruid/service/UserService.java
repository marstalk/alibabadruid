package com.marstalk.alibabadruid.service;

import com.marstalk.alibabadruid.dao.UserDao;
import com.marstalk.alibabadruid.domain.User;

import java.util.concurrent.Callable;


public class UserService implements Callable {
    private UserDao userDao;
    private User user;

    public UserService(UserDao userDao, User user) {
        this.userDao = userDao;
        this.user = user;
    }

    @Override
    public Object call() throws Exception {
        User savedUser = userDao.save(user);
        return savedUser;
    }
}
