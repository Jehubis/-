package com.equdemo.dao.impl;

import com.equdemo.commons.JdbcUtils;
import com.equdemo.dao.UserManagerDao;
import com.equdemo.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManagerDaoImpl implements UserManagerDao {
    @Override
    public void insertUser(Users users) {
        Connection conn = null;
        try{
            conn= JdbcUtils.getConnection();
            conn.setAutoCommit(false);//关闭事务自动提交
            PreparedStatement ps = conn.prepareStatement("insert  into users values (default ,?,?,?,?,?)");
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getUserpwd());
            ps.setString(3,users.getUserpower());
            ps.setString(4,users.getUsersex());
            ps.setString(5,users.getPhonenumber());
            ps.execute();//执行SQL语句
            conn.commit();//事务提交
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtils.rollbackConnection(conn);
        }finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    /**
     * 查询用户
     * @param users
     * @return
     */
    @Override
    public List<Users> selectUsersByProperty(Users users) {
        Connection conn = null;
        List<Users> list = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = this.createSQL(users);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Users user = new Users();
                user.setUserid(resultSet.getInt("userid"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setUserpower(resultSet.getString("userpower"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return list;
    }

    /**
     * 根据id查询用户
     * @param userid
     * @return
     */
    @Override
    public Users selectUserByUserId(int userid) {
        Connection conn = null;
        Users user = null;
        try{
            conn = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from users where userid = ? ");
            preparedStatement.setInt(1,userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new Users();
                user.setUserid(resultSet.getInt("userid"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setUserpower(resultSet.getString("userpower"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return user;
    }

    /**
     * 更新用户
     * @param users
     */
    @Override
    public void updateUserByUserId(Users users) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("update users set username = ? ,userpwd = ? , userpower = ? , usersex = ? , phonenumber = ? where userid = ?");
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getUserpwd());
            preparedStatement.setString(3,users.getUserpower());
            preparedStatement.setString(4,users.getUsersex());
            preparedStatement.setString(5,users.getPhonenumber());
            preparedStatement.setInt(6,users.getUserid());
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtils.rollbackConnection(conn);
        }finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    /**
     * 根据用户id删除用户
     * @param userid
     */
    @Override
    public void deleteUserByUserId(int userid) {
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("delete from users where userid = ?");
            preparedStatement.setInt(1,userid);
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtils.rollbackConnection(conn);
        }finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    //拼接查询的SQL语句
    private String createSQL(Users users){
        StringBuffer stringBuffer = new StringBuffer("select * from users where 1=1 ");
        if(users.getUsername() != null && users.getUsername().length() > 0){
            stringBuffer.append(" and username = '"+users.getUsername()+"'");
        }
        if(users.getUserpower() != null && users.getUserpower().length() > 0){
            stringBuffer.append(" and userpower = "+users.getUserpower());
        }
        if(users.getUsersex() != null && users.getUsersex().length() > 0){
            stringBuffer.append(" and usersex = "+users.getUsersex());
        }
        if(users.getPhonenumber() != null && users.getPhonenumber().length() > 0){
            stringBuffer.append(" and phonenumber = "+users.getPhonenumber());
        }
        return stringBuffer.toString();
    }
}
