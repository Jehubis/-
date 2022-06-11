package com.equdemo.dao.impl;

import com.equdemo.commons.JdbcUtils;
import com.equdemo.dao.UserLoginDao;
import com.equdemo.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDaoImpl implements UserLoginDao {
    @Override
    public Users selectUsersByUserNameAndUserPwd(String username, String userpwd,String userpower) {
        Users user = null;
        Connection conn = null;
        try{
            conn = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from users where username = ? and userpwd = ? and userpower = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,userpwd);
            preparedStatement.setString(3,userpower);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new Users();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
                user.setUserpower(resultSet.getString("userpower"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
