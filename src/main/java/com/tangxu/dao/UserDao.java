package com.tangxu.dao;

import com.tangxu.pojo.User;

import java.util.List;

public interface UserDao {
     void save();
     List<User> findUserList();
}
