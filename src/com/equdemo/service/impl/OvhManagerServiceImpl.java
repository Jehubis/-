package com.equdemo.service.impl;


import com.equdemo.dao.OvhManagerDao;
import com.equdemo.dao.impl.OvhManagerDaoImpl;
import com.equdemo.pojo.Overhaul;
import com.equdemo.service.OvhManagerService;

import java.util.List;

public class OvhManagerServiceImpl implements OvhManagerService {
    @Override
    public void addOvh(Overhaul overhaul) {
        OvhManagerDao ovhManagerDao = new OvhManagerDaoImpl();
        ovhManagerDao.insertOvh(overhaul);
    }

    @Override
    public List<Overhaul> findOvh(Overhaul overhaul) {
        OvhManagerDao ovhManagerDao = new OvhManagerDaoImpl();
        return ovhManagerDao.selectOvhByProperty(overhaul);
    }

    @Override
    public Overhaul findOvhByOvhId(int ovhid) {
        OvhManagerDao ovhManagerDao = new OvhManagerDaoImpl();
        return ovhManagerDao.selectOvhByOvhId(ovhid);
    }

    @Override
    public void modifyOvh(Overhaul overhaul) {
        OvhManagerDao ovhManagerDao = new OvhManagerDaoImpl();
        ovhManagerDao.updateOvhByOvhId(overhaul);
    }

    @Override
    public void dropOvh(int ovhid) {
        OvhManagerDao ovhManagerDao = new OvhManagerDaoImpl();
        ovhManagerDao.deleteOvhByOvhId(ovhid);
    }
}
