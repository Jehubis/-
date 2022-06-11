package com.equdemo.service;

import com.equdemo.pojo.Overhaul;

import java.util.List;

public interface OvhManagerService {
    void addOvh(Overhaul overhaul);
    List<Overhaul> findOvh(Overhaul overhaul);
    Overhaul findOvhByOvhId(int ovhid);
    void modifyOvh(Overhaul overhaul);
    void dropOvh(int ovhid);
}
