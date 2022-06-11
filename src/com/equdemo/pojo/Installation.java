package com.equdemo.pojo;

import java.sql.Blob;

public class Installation {
    private int instid;
    private String instposition;
    private String instdate;
    private String instdirector;
    private String instunit;
    private String inspector;
    private String userunit;
    private String equ_name;
    private String equ_num;

    public int getInstid() {
        return instid;
    }

    public void setInstid(int instid) {
        this.instid = instid;
    }

    public String getInstposition() {
        return instposition;
    }

    public void setInstposition(String instposition) {
        this.instposition = instposition;
    }

    public String getInstdate() {
        return instdate;
    }

    public void setInstdate(String instdate) {
        this.instdate = instdate;
    }


    public String getInstdirector() {
        return instdirector;
    }

    public void setInstdirector(String instdirector) {
        this.instdirector = instdirector;
    }

    public String getInstunit() {
        return instunit;
    }

    public void setInstunit(String instunit) {
        this.instunit = instunit;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getUserunit() {
        return userunit;
    }

    public void setUserunit(String userunit) {
        this.userunit = userunit;
    }

    public String getEqu_name() {
        return equ_name;
    }

    public void setEqu_name(String equ_name) {
        this.equ_name = equ_name;
    }

    public String getEqu_num() {
        return equ_num;
    }

    public void setEqu_num(String equ_num) {
        this.equ_num = equ_num;
    }
}
