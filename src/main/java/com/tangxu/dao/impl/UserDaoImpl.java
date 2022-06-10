package com.tangxu.dao.impl;

import com.tangxu.dao.UserDao;
import com.tangxu.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }
    public List<User> findUserList() {
        return Collections.singletonList(new User("pdai", 18));
    }

    @Override
    public void save() {
        System.out.println("save running");
    }
}
