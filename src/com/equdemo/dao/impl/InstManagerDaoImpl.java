package com.equdemo.dao.impl;

import com.equdemo.commons.JdbcUtils;
import com.equdemo.dao.InstManagerDao;
import com.equdemo.pojo.Installation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InstManagerDaoImpl implements InstManagerDao {
    @Override
    public void insertInst(Installation installation) {
        Connection conn = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into installation values (default ,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,installation.getInstposition());
            preparedStatement.setString(2,installation.getInstdate());
            preparedStatement.setString(3,installation.getInstdirector());
            preparedStatement.setString(4,installation.getInstunit());
            preparedStatement.setString(5,installation.getInspector());
            preparedStatement.setString(6,installation.getUserunit());
            preparedStatement.setString(7,installation.getEqu_name());
            preparedStatement.setString(8,installation.getEqu_num());
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtils.rollbackConnection(conn);
        }finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    public List<Installation> selectInstByProperty(Installation installation) {
        Connection conn = null;
        List<Installation> list = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = this.createSQL(installation);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Installation installation1 = new Installation();
                installation1.setInstid(resultSet.getInt("instid"));
                installation1.setInstposition(resultSet.getString("instposition"));
                installation1.setInstdate(resultSet.getString("instdate"));
                installation1.setInstdirector(resultSet.getString("instdirector"));
                installation1.setInstunit(resultSet.getString("instunit"));
                installation1.setInspector(resultSet.getString("inspector"));
                installation1.setUserunit(resultSet.getString("userunit"));
                installation1.setEqu_name(resultSet.getString("equ_name"));
                installation1.setEqu_num(resultSet.getString("equ_num"));
                list.add(installation1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Installation selectInstByInstId(int instid) {
        Connection conn = null;
        Installation installation1 = null;
        try{
            conn = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select  * from installation where instid = ?");
            preparedStatement.setInt(1,instid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                installation1 = new Installation();
                installation1.setInstid(resultSet.getInt("instid"));
                installation1.setInstposition(resultSet.getString("instposition"));
                installation1.setInstdate(resultSet.getString("instdate"));
                installation1.setInstdirector(resultSet.getString("instdirector"));
                installation1.setInstunit(resultSet.getString("instunit"));
                installation1.setInspector(resultSet.getString("inspector"));
                installation1.setUserunit(resultSet.getString("userunit"));
                installation1.setEqu_name(resultSet.getString("equ_name"));
                installation1.setEqu_num(resultSet.getString("equ_num"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return installation1;
    }

    @Override
    public void updateInstByInstId(Installation installation) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("update installation set instposition = ? , instdate = ? , instdirector = ? , instunit = ? , inspector = ? , userunit = ? , equ_name = ? ,equ_num = ? where instid = ?");
            preparedStatement.setString(1,installation.getInstposition());
            preparedStatement.setString(2,installation.getInstdate());
            preparedStatement.setString(3,installation.getInstdirector());
            preparedStatement.setString(4,installation.getInstunit());
            preparedStatement.setString(5,installation.getInspector());
            preparedStatement.setString(6,installation.getUserunit());
            preparedStatement.setString(7,installation.getEqu_name());
            preparedStatement.setString(8,installation.getEqu_num());
            preparedStatement.setInt(9,installation.getInstid());
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtils.rollbackConnection(conn);
        }finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    public void deleteInstByInstId(int instid) {
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("delete from installation where instid = ?");
            preparedStatement.setInt(1,instid);
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
    private String createSQL(Installation installation){
        StringBuffer stringBuffer = new StringBuffer("select * from installation where 1 = 1  ");
        if(installation.getInstposition() != null && installation.getInstposition() .length() > 0){
            stringBuffer.append(" and instposition = '"+installation.getInstposition() +"'");
        }
        if(installation.getInstdate() != null && installation.getInstdate().length() > 0){
            stringBuffer.append(" and instdate = '"+installation.getInstdate()+"'");
        }
        if(installation.getInstdirector() != null && installation.getInstdirector().length() > 0){
            stringBuffer.append(" and instdirector = '"+installation.getInstdirector()+"'");
        }
        if(installation.getInstunit() != null && installation.getInstunit().length() > 0){
            stringBuffer.append(" and instunit = '"+installation.getInstunit()+"'");
        }
        if(installation.getInspector() != null && installation.getInspector().length() > 0){
            stringBuffer.append(" and inspector = '"+installation.getInspector()+"'");
        }
        if(installation.getUserunit() != null && installation.getUserunit().length() > 0){
            stringBuffer.append(" and userunit = '"+installation.getUserunit()+"'");
        }
        if(installation.getEqu_name() != null && installation.getEqu_name().length() > 0){
            stringBuffer.append(" and equ_name = '"+installation.getEqu_name()+"'");
        }
        if(installation.getEqu_num() != null && installation.getEqu_num().length() > 0){
            stringBuffer.append(" and equ_num = '"+installation.getEqu_num()+"'");
        }
        return stringBuffer.toString();
    }
}
