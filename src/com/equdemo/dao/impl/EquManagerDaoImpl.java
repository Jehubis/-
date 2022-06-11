package com.equdemo.dao.impl;

import com.equdemo.commons.JdbcUtils;
import com.equdemo.dao.EquManagerDao;
import com.equdemo.pojo.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquManagerDaoImpl implements EquManagerDao {
    @Override
    public void insertEqu(Equipment equipment) {
        Connection conn = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into equipment values (default ,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,equipment.getEqunum());
            preparedStatement.setString(2,equipment.getEquname());
            preparedStatement.setString(3,equipment.getEqutype());
            preparedStatement.setString(4,equipment.getEqusupplier());
            preparedStatement.setString(5,equipment.getNumofequ());
            preparedStatement.setString(6,equipment.getPrice());
            preparedStatement.setString(7,equipment.getDate());
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
    public List<Equipment> selectEquByProperty(Equipment equipment) {
        Connection conn = null;
        List<Equipment> list = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = this.createSQL(equipment);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Equipment equipment1 = new Equipment();
                equipment1.setEquid(resultSet.getInt("equid"));
                equipment1.setEquname(resultSet.getString("equname"));
                equipment1.setEqunum(resultSet.getString("equnum"));
                equipment1.setEqutype(resultSet.getString("equtype"));
                equipment1.setEqusupplier(resultSet.getString("equsupplier"));
                equipment1.setNumofequ(resultSet.getString("numofequ"));
                equipment1.setPrice(resultSet.getString("price"));
                equipment1.setDate(resultSet.getString("date"));
                list.add(equipment1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Equipment selectEquByEquId(int equid) {
        Connection conn = null;
        Equipment equipment1 = null;
        try{
            conn = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select  * from equipment where equid = ?");
            preparedStatement.setInt(1,equid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                equipment1 = new Equipment();
                equipment1.setEquid(resultSet.getInt("equid"));
                equipment1.setEquname(resultSet.getString("equname"));
                equipment1.setEqunum(resultSet.getString("equnum"));
                equipment1.setEqutype(resultSet.getString("equtype"));
                equipment1.setEqusupplier(resultSet.getString("equsupplier"));
                equipment1.setNumofequ(resultSet.getString("numofequ"));
                equipment1.setPrice(resultSet.getString("price"));
                equipment1.setDate(resultSet.getString("date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(conn);
        }
        return equipment1;
    }

    @Override
    public void updateEquByEquId(Equipment equipment) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("update equipment set equname = ? , equnum = ? , equtype = ? , equsupplier = ? , numofequ = ? , price = ? , date = ? where equid = ?");
            preparedStatement.setString(1,equipment.getEquname());
            preparedStatement.setString(2,equipment.getEqunum());
            preparedStatement.setString(3,equipment.getEqutype());
            preparedStatement.setString(4,equipment.getEqusupplier());
            preparedStatement.setString(5,equipment.getNumofequ());
            preparedStatement.setString(6,equipment.getPrice());
            preparedStatement.setString(7,equipment.getDate());
            preparedStatement.setInt(8,equipment.getEquid());
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
    public void deleteEquByEquId(int equid) {
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("delete from equipment where equid = ?");
            preparedStatement.setInt(1,equid);
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
    private String createSQL(Equipment equipment){
        StringBuffer stringBuffer = new StringBuffer("select * from equipment where 1 = 1  ");
        if(equipment.getEquname() != null && equipment.getEquname().length() > 0){
            stringBuffer.append(" and equname = '"+equipment.getEquname()+"'");
        }
        if(equipment.getEqunum() != null && equipment.getEqunum().length() > 0){
            stringBuffer.append(" and equnum = '"+equipment.getEqunum()+"'");
        }
        if(equipment.getEqutype() != null && equipment.getEqutype().length() > 0){
            stringBuffer.append(" and equtype = '"+equipment.getEqutype()+"'");
        }
        if(equipment.getEqusupplier() != null && equipment.getEqusupplier().length() > 0){
            stringBuffer.append(" and equsupplier = '"+equipment.getEqusupplier()+"'");
        }
        if(equipment.getNumofequ() != null && equipment.getNumofequ().length() > 0){
            stringBuffer.append(" and numofequ = '"+equipment.getNumofequ()+"'");
        }
        if(equipment.getPrice() != null && equipment.getPrice().length() > 0){
            stringBuffer.append(" and price = '"+equipment.getPrice()+"'");
        }
        if(equipment.getDate() != null && equipment.getDate().length() > 0){
            stringBuffer.append(" and date = '"+equipment.getDate()+"'");
        }
        return stringBuffer.toString();
    }
}
