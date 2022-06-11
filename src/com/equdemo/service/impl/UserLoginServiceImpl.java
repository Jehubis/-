package com.equdemo.service.impl;

import com.equdemo.dao.UserLoginDao;
import com.equdemo.dao.impl.UserLoginDaoImpl;
import com.equdemo.exception.UserNotFoundException;
import com.equdemo.pojo.Users;
import com.equdemo.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

    @Override
    public Users userLogin(String username, String userpwd,String userpower ) {
        UserLoginDao userLoginDao = new UserLoginDaoImpl();
        Users users = userLoginDao.selectUsersByUserNameAndUserPwd(username, userpwd,userpower);
        if (users == null){
            throw new UserNotFoundException("用户名或密码或权限选择有误!");
        }
        return users;
    }
}
