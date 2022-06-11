package com.equdemo.service.impl;

import com.equdemo.dao.InstManagerDao;
import com.equdemo.dao.impl.InstManagerDaoImpl;
import com.equdemo.pojo.Installation;
import com.equdemo.service.InstManagerService;

import java.util.List;

public class InstManagerServiceImpl implements InstManagerService {
    @Override
    public void addInst(Installation installation) {
        InstManagerDao instManagerDao = new InstManagerDaoImpl();
        instManagerDao.insertInst(installation);
    }

    @Override
    public List<Installation> findInst(Installation installation) {
        InstManagerDao instManagerDao = new InstManagerDaoImpl();
        return instManagerDao.selectInstByProperty(installation);
    }

    @Override
    public Installation findInstByInstId(int instid) {
        InstManagerDao instManagerDao = new InstManagerDaoImpl();
        return instManagerDao.selectInstByInstId(instid);
    }

    @Override
    public void modifyInst(Installation installation) {
        InstManagerDao instManagerDao = new InstManagerDaoImpl();
        instManagerDao.updateInstByInstId(installation);
    }

    @Override
    public void dropInst(int instid) {
        InstManagerDao instManagerDao = new InstManagerDaoImpl();
        instManagerDao.deleteInstByInstId(instid);
    }
}
