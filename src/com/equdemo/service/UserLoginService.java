package com.equdemo.service;

import com.equdemo.pojo.Users;

public interface UserLoginService {
    public Users userLogin(String username,String userpwd,String userpower);
}
