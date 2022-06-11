package com.equdemo.dao;


import com.equdemo.pojo.Installation;

import java.util.List;

public interface InstManagerDao {
    void insertInst(Installation installation);
    List<Installation> selectInstByProperty(Installation installation);
    Installation selectInstByInstId(int instid);
    void updateInstByInstId(Installation installation);
    void deleteInstByInstId(int instid);
}
