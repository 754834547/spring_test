package com.tangxu.service.impl;

import com.tangxu.dao.UserDao;
import com.tangxu.pojo.User;
import com.tangxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Value("${jdbc.url}")
    private String url;
    @Autowired
    private UserDao userDao;
    public List<User> findUserList() {
        System.out.println("execute method findUserList");
        return this.userDao.findUserList();
    }
    @Override
    public void save() {
        System.out.println(url);
        userDao.save();
    }
}
