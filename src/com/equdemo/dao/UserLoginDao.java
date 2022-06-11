package com.equdemo.dao;

import com.equdemo.pojo.Users;

public interface UserLoginDao {
    public Users selectUsersByUserNameAndUserPwd(String username,String userpwd,String userpower);
}
