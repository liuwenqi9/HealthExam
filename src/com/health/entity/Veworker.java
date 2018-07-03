package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Veworker {
    private Integer workerid;

    private Object name;

    private Object deptname;

    private Object rolename;

    private Short state;

    public Integer getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Integer workerid) {
        this.workerid = workerid;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getDeptname() {
        return deptname;
    }

    public void setDeptname(Object deptname) {
        this.deptname = deptname;
    }

    public Object getRolename() {
        return rolename;
    }

    public void setRolename(Object rolename) {
        this.rolename = rolename;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}