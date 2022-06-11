package com.equdemo.dao;

import com.equdemo.pojo.Equipment;

import java.util.List;

public interface EquManagerDao {
    void insertEqu(Equipment equipment);
    List<Equipment> selectEquByProperty(Equipment equipment);
    Equipment selectEquByEquId(int equid);
    void updateEquByEquId(Equipment equipment);
    void deleteEquByEquId(int equid);
}
