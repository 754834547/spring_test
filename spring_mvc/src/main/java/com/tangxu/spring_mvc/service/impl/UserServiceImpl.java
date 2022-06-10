package com.tangxu.spring_mvc.service.impl;

import com.tangxu.spring_mvc.dao.UserDao;
import com.tangxu.spring_mvc.dao.impl.UserDaoImpl;
import com.tangxu.spring_mvc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
