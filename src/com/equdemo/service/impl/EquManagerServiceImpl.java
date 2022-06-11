package com.equdemo.service.impl;

import com.equdemo.dao.EquManagerDao;
import com.equdemo.dao.impl.EquManagerDaoImpl;
import com.equdemo.pojo.Equipment;
import com.equdemo.service.EquManagerService;

import java.util.List;

public class EquManagerServiceImpl implements EquManagerService {
    /**
     * 添加设备
     * @param equipment
     */
    @Override
    public void addEqu(Equipment equipment) {
        EquManagerDao equManagerDao = new EquManagerDaoImpl();
        equManagerDao.insertEqu(equipment);
    }

    @Override
    public List<Equipment> findEqu(Equipment equipment) {
        EquManagerDao equManagerDao = new EquManagerDaoImpl();
        return equManagerDao.selectEquByProperty(equipment);
    }

    @Override
    public Equipment findEquByEquId(int equid) {
        EquManagerDao equManagerDao = new EquManagerDaoImpl();
        return equManagerDao.selectEquByEquId(equid);
    }

    @Override
    public void modifyEqu(Equipment equipment) {
        EquManagerDao equManagerDao = new EquManagerDaoImpl();
        equManagerDao.updateEquByEquId(equipment);
    }

    @Override
    public void dropEqu(int equid) {
        EquManagerDao equManagerDao = new EquManagerDaoImpl();
        equManagerDao.deleteEquByEquId(equid);
    }
}
