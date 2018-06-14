package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Dept {
    private Integer deptid;

    private Object deptname;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Object getDeptname() {
        return deptname;
    }

    public void setDeptname(Object deptname) {
        this.deptname = deptname;
    }
}