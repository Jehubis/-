package com.equdemo.dao;

import com.equdemo.pojo.Users;

import java.util.List;

public interface UserManagerDao {
    void insertUser(Users users);
    List<Users> selectUsersByProperty(Users users);
    Users selectUserByUserId(int userid);
    void updateUserByUserId(Users users);
    void deleteUserByUserId(int userid);
}
