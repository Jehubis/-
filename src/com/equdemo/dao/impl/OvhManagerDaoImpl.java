package com.equdemo.dao.impl;

import com.equdemo.commons.JdbcUtils;
import com.equdemo.dao.OvhManagerDao;
import com.equdemo.pojo.Overhaul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OvhManagerDaoImpl implements OvhManagerDao {
    @Override
    public void insertOvh(Overhaul overhaul) {
        Connection conn = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into overhaul values (default ,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,overhaul.getRepairman());
            preparedStatement.setString(2,overhaul.getPhonenumber());
            preparedStatement.setString(3,overhaul.getOvhresult());
            preparedStatement.setString(4,overhaul.getRemarks());
            preparedStatement.setString(5,overhaul.getOvhdate());
            preparedStatement.setString(6,overhaul.getEqu_num());
            preparedStatement.setString(7,overhaul.getEqu_name());
            preparedStatement.setString(8,overhaul.getEqu_type());
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
    public List<Overhaul> selectOvhByProperty(Overhaul overhaul) {
        Connection conn = null;
        List<Overhaul> list = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = this.createSQL(overhaul);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Overhaul overhaul1 = new Overhaul();
                overhaul1.setOvhid(resultSet.getInt("ovhid"));
                overhaul1.setRepairman(resultSet.getString("repairman"));
                overhaul1.setPhonenumber(resultSet.getString("phonenumber"));
                overhaul1.setOvhresult(resultSet.getString("ovhresult"));
                overhaul1.setRemarks(resultSet.getString("remarks"));
                overhaul1.setOvhdate(resultSet.getString("ovhdate"));
                overhaul1.setEqu_num(resultSet.getString("equ_num"));
                overhaul1.setEqu_name(resultSet.getString("equ_name"));
                overhaul1.setEqu_type(resultSet.getString("equ_type"));
                list.add(overhaul1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Overhaul selectOvhByOvhId(int ovhid) {
        Connection conn = null;
        Overhaul overhaul1 = null;
        try{
            conn = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select  * from overhaul where ovhid = ?");
            preparedStatement.setInt(1,ovhid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                overhaul1 = new Overhaul();
                overhaul1.setOvhid(resultSet.getInt("ovhid"));
                overhaul1.setRepairman(resultSet.getString("repairman"));
                overhaul1.setPhonenumber(resultSet.getString("phonenumber"));
                overhaul1.setOvhresult(resultSet.getString("ovhresult"));
                overhaul1.setRemarks(resultSet.getString("remarks"));
                overhaul1.setOvhdate(resultSet.getString("ovhdate"));
                overhaul1.setEqu_num(resultSet.getString("equ_num"));
                overhaul1.setEqu_name(resultSet.getString("equ_name"));
                overhaul1.setEqu_type(resultSet.getString("equ_type"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return overhaul1;
    }

    @Override
    public void updateOvhByOvhId(Overhaul overhaul) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("update overhaul set repairman = ? , phonenumber = ? , ovhresult = ? , remarks = ? , ovhdate = ? , equ_num = ? , equ_name = ? , equ_type = ? where ovhid = ?");
            preparedStatement.setString(1,overhaul.getRepairman());
            preparedStatement.setString(2,overhaul.getPhonenumber());
            preparedStatement.setString(3,overhaul.getOvhresult());
            preparedStatement.setString(4,overhaul.getRemarks());
            preparedStatement.setString(5,overhaul.getOvhdate());
            preparedStatement.setString(6,overhaul.getEqu_num());
            preparedStatement.setString(7,overhaul.getEqu_name());
            preparedStatement.setString(8,overhaul.getEqu_type());
            preparedStatement.setInt(9,overhaul.getOvhid());
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
    public void deleteOvhByOvhId(int ovhid) {
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("delete from overhaul where ovhid = ?");
            preparedStatement.setInt(1,ovhid);
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
    private String createSQL(Overhaul overhaul){
        StringBuffer stringBuffer = new StringBuffer("select * from overhaul where 1 = 1  ");
        if(overhaul.getRepairman() != null && overhaul.getRepairman().length() > 0){
            stringBuffer.append(" and repairman = '"+overhaul.getRepairman()+"'");
        }
        if(overhaul.getPhonenumber() != null && overhaul.getPhonenumber().length() > 0){
            stringBuffer.append(" and phonenumber = '"+overhaul.getPhonenumber()+"'");
        }
        if(overhaul.getOvhresult() != null && overhaul.getOvhresult().length() > 0){
            stringBuffer.append(" and ovhresult = '"+overhaul.getOvhresult()+"'");
        }
        if(overhaul.getRemarks() != null && overhaul.getRemarks().length() > 0){
            stringBuffer.append(" and remarks = '"+overhaul.getRemarks()+"'");
        }
        if(overhaul.getOvhdate() != null && overhaul.getOvhdate().length() > 0){
            stringBuffer.append(" and ovhdate = '"+overhaul.getOvhdate()+"'");
        }
        if(overhaul.getEqu_num() != null && overhaul.getEqu_num().length() > 0){
            stringBuffer.append(" and equ_num = '"+overhaul.getEqu_num()+"'");
        }
        if(overhaul.getEqu_name() != null && overhaul.getEqu_name().length() > 0){
            stringBuffer.append(" and equ_name = '"+overhaul.getEqu_name()+"'");
        }
        if(overhaul.getEqu_type() != null && overhaul.getEqu_type().length() > 0){
            stringBuffer.append(" and equ_type = '"+overhaul.getEqu_type()+"'");
        }
        return stringBuffer.toString();
    }
}
