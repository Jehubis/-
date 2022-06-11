package com.equdemo.service;

import com.equdemo.pojo.Equipment;

import java.util.List;

public interface EquManagerService  {
    void addEqu(Equipment equipment);
    List<Equipment> findEqu(Equipment equipment);
    Equipment findEquByEquId(int equid);
    void modifyEqu(Equipment equipment);
    void dropEqu(int equid);
}
