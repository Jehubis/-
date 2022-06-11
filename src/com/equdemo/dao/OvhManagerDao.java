package com.equdemo.dao;

import com.equdemo.pojo.Overhaul;

import java.util.List;

public interface OvhManagerDao {
    void insertOvh(Overhaul overhaul);
    List<Overhaul> selectOvhByProperty(Overhaul overhaul);
    Overhaul selectOvhByOvhId(int ovhid);
    void updateOvhByOvhId(Overhaul overhaul);
    void deleteOvhByOvhId(int ovhid);
}
