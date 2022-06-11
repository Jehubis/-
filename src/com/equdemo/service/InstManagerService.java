package com.equdemo.service;

import com.equdemo.pojo.Equipment;
import com.equdemo.pojo.Installation;

import java.util.List;

public interface InstManagerService {
    void addInst(Installation installation);
    List<Installation> findInst(Installation installation);
    Installation findInstByInstId(int instid);
    void modifyInst(Installation installation);
    void dropInst(int instid);
}
