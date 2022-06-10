package com.tangxu.spring_mvc.dao.impl;

import com.tangxu.spring_mvc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running");
    }
}
