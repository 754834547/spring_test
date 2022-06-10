package com.tangxu.service;

import com.tangxu.pojo.User;

import java.util.List;

public interface UserService {
    public void save();
    public List<User> findUserList();
}
